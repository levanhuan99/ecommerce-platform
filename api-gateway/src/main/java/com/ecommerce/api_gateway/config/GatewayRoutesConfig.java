package com.ecommerce.api_gateway.config;
import com.ecommerce.api_gateway.filter.JwtAuthFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfig {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder, JwtAuthFilter jwtAuthFilter) {
      return builder.routes()
                .route("user-service", r -> r.path("/api/user/**", "/oauth2/authorization/github")
                        .filters(f -> f.filter(jwtAuthFilter))
                        .uri("http://localhost:8088"))
                .route("notification-service", r -> r.path("/api/notification/**")
                        .filters(f -> f.filter(jwtAuthFilter))
                        .uri("http://localhost:8083"))
                .route("product-catalog-service", r -> r.path("/api/product/**")
                        .filters(f -> f.filter(jwtAuthFilter))
                        .uri("http://localhost:8086"))
                .build();  
    }
}
