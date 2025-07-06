# Scalable Ecommerce Platform

A microservices-based ecommerce platform built with Spring Boot, featuring a comprehensive architecture with multiple specialized services.

## 🏗️ Architecture Overview

This platform follows a microservices architecture pattern with the following components:

### Core Services
- **API Gateway** - Central entry point for all client requests
- **Eureka Server** - Service discovery and registration
- **User Service** - User management and authentication
- **Product Catalog Service** - Product management and catalog
- **Shopping Cart Service** - Cart management
- **Order Service** - Order processing and management
- **Payment Service** - Payment processing
- **Notification Service** - Email, SMS, and push notifications

### Shared Components
- **Authentication Utility** - JWT token management and validation

## 🚀 Quick Start

### Prerequisites
- Java 24
- Maven 3.6+
- Docker (optional, for containerization)

### Running the Platform

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd scalable-ecommerce-platform
   ```

2. **Build all services**
   ```bash
   mvn clean install
   ```

3. **Start services in order**
   ```bash
   # 1. Start Eureka Server (Service Discovery)
   cd eureka-server
   mvn spring-boot:run

   # 2. Start API Gateway
   cd ../api-gateway
   mvn spring-boot:run

   # 3. Start other services
   cd ../user-service
   mvn spring-boot:run

   cd ../product-catalog-service
   mvn spring-boot:run

   cd ../shopping-cart-service
   mvn spring-boot:run

   cd ../order-service
   mvn spring-boot:run

   cd ../payment-service
   mvn spring-boot:run

   cd ../notification-service
   mvn spring-boot:run
   ```

## 📋 Service Details

### API Gateway (`api-gateway`)
- **Port**: 8080
- **Purpose**: Central routing and authentication
- **Features**: 
  - JWT authentication filter
  - Route configuration
  - Request/response transformation

### Eureka Server (`eureka-server`)
- **Port**: 8761
- **Purpose**: Service discovery and registration
- **Features**: 
  - Service registry
  - Health monitoring
  - Load balancing support

### User Service (`user-service`)
- **Port**: 8081
- **Purpose**: User management and authentication
- **Features**:
  - User registration/login
  - Profile management
  - JWT token generation

### Product Catalog Service (`product-catalog-service`)
- **Port**: 8082
- **Purpose**: Product management
- **Features**:
  - Product catalog
  - Category management
  - Inventory tracking
  - REST API endpoints

### Shopping Cart Service (`shopping-cart-service`)
- **Port**: 8083
- **Purpose**: Cart management
- **Features**:
  - Add/remove items
  - Cart persistence
  - Price calculation

### Order Service (`order-service`)
- **Port**: 8084
- **Purpose**: Order processing
- **Features**:
  - Order creation
  - Order status tracking
  - Order history

### Payment Service (`payment-service`)
- **Port**: 8085
- **Purpose**: Payment processing
- **Features**:
  - Payment gateway integration
  - Transaction management
  - Payment verification

### Notification Service (`notification-service`)
- **Port**: 8086
- **Purpose**: Notifications
- **Features**:
  - Email notifications
  - SMS notifications
  - Push notifications

## 🔧 Configuration

### Logging
The platform uses Log4j2 for centralized logging:
- Configuration: `log4j2.xml` (copy to each service's `src/main/resources/`)
- Log levels: INFO (default), DEBUG for application code
- Log files: `logs/application.log`, `logs/error.log`, `logs/performance.log`

### Environment Variables
Key configuration properties:
```yaml
# Database
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
spring.datasource.username=root
spring.datasource.password=password

# JWT
jwt.secret=your-secret-key
jwt.expiration=86400000

# Eureka
eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```

## 🛠️ Development

### Project Structure
```
scalable-ecommerce-platform/
├── api-gateway/                 # API Gateway service
├── authentication-util/         # JWT utilities
├── eureka-server/              # Service discovery
├── notification-service/        # Notification service
├── order-service/              # Order management
├── payment-service/            # Payment processing
├── product-catalog-service/    # Product catalog
├── shopping-cart-service/      # Shopping cart
├── user-service/              # User management
├── pom.xml                    # Parent POM
└── log4j2.xml                # Logging configuration
```

### Adding New Services
1. Create new service directory
2. Add module to parent `pom.xml`
3. Configure service-specific `application.yml`
4. Copy `log4j2.xml` to service resources
5. Register service with Eureka

### API Documentation
Each service exposes REST APIs:
- **Product Catalog**: `http://localhost:8082/api/product/`
- **User Service**: `http://localhost:8081/api/user/`
- **Shopping Cart**: `http://localhost:8083/api/cart/`
- **Orders**: `http://localhost:8084/api/orders/`

## 🔒 Security

### Authentication
- JWT-based authentication
- Token validation in API Gateway
- Public endpoints: `/api/user/login`, `/api/user/sign-up`

### Authorization
- Role-based access control
- Service-to-service authentication
- Secure communication between services

## 📊 Monitoring

### Health Checks
- Eureka dashboard: `http://localhost:8761`
- Service health endpoints: `/actuator/health`

### Logging
- Centralized logging with Log4j2
- Structured log format
- Log rotation and archiving

## 🚀 Deployment

### Docker Support
Each service can be containerized:
```bash
# Build Docker images
docker build -t ecommerce-api-gateway api-gateway/
docker build -t ecommerce-user-service user-service/
# ... repeat for other services

# Run with Docker Compose
docker-compose up
```

### Kubernetes
- Helm charts available for deployment
- Service mesh integration
- Horizontal pod autoscaling

## 🤝 Contributing

1. Fork the repository
2. Create feature branch
3. Make changes
4. Add tests
5. Submit pull request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🆘 Support

For support and questions:
- Create an issue in the repository
- Contact the development team
- Check the documentation

---

**Built with ❤️ using Spring Boot and Microservices Architecture** 