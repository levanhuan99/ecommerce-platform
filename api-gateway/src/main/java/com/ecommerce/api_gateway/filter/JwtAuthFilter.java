package com.ecommerce.api_gateway.filter;

import ecommerce.jwt.JwtUtil;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
public class JwtAuthFilter implements GatewayFilter {
    private static final List<String> PUBLIC_PATHS = List.of(
            "/api/user/login",
            "/api/user/sign-up"
    );
    /**
     * Filter all request from clients to all services before the real service processes
     * @param exchange
     * @param chain
     * @return
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getURI().getPath();
        System.out.println("path uri: " + path);
        if (isPublicEndpoint(path)) {
            return chain.filter(exchange);
        }
        Optional<String> authHeader = Optional.ofNullable(
                exchange.getRequest().getHeaders().getFirst("Authorization")
        );
        if (authHeader.isEmpty()) {
            return getVoidMono(exchange);
        }
        if (!authHeader.get().startsWith("Bearer ")) {
            return getVoidMono(exchange);
        }
        String token = authHeader.get().substring(7);
        if (!JwtUtil.validateToken(token)) {
            return getVoidMono(exchange);
        }
        return chain.filter(exchange);
    }
    private boolean isPublicEndpoint(String path) {
        return PUBLIC_PATHS.stream().anyMatch(path::equalsIgnoreCase);
    }

    private static Mono<Void> getVoidMono(ServerWebExchange exchange) {
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }



}
