# 电商系统 (E-commerce System)

## 项目简介
这是一个基于微服务架构的电商系统，包含商品管理、订单处理、支付服务、用户管理和API网关等核心模块。系统采用Spring Boot构建，支持容器化部署，具有高可用性和可扩展性。

## 技术栈
- **后端框架**: Spring Boot, Spring Cloud
- **构建工具**: Maven
- **容器化**: Docker, Docker Compose
- **API网关**: Spring Cloud Gateway
- **数据库**: MySQL
- **消息队列**: Kafka 
- **服务发现与注册**: Eureka/Nacos
- **负载均衡**: Ribbon

## 项目结构
```
ecommerce-system/
├── gateway-service/       # API网关服务
├── order-service/         # 订单服务
├── payment-service/       # 支付服务
├── product-service/       # 商品服务
├── user-service/          # 用户服务
├── docker-compose.yml     # Docker Compose配置
├── nginx.conf             # Nginx配置
└── pom.xml                # 父项目POM文件
```

## 各模块功能说明

### 1. 网关服务 (gateway-service)
- 请求路由与转发
- 负载均衡
- 认证与授权
- 请求限流与熔断

### 2. 订单服务 (order-service)
- 订单创建与管理
- 订单状态跟踪
- 库存检查与预留
- 订单取消与退款处理

### 3. 支付服务 (payment-service)
- 支付方式集成
- 支付流程处理
- 交易记录管理
- 支付结果通知

### 4. 商品服务 (product-service)
- 商品信息管理
- 商品分类与标签
- 库存管理
- 商品搜索与筛选

### 5. 用户服务 (user-service)
- 用户注册与登录
- 用户信息管理
- 地址管理
- 购物车功能

## 环境要求
- JDK 11+ 
- Maven 3.6+ 
- Docker 20.10+ 
- Docker Compose 1.29+

## 本地开发与运行

### 1. 构建项目
```bash
# 构建所有模块
mvn clean install -DskipTests
```

### 2. 使用Docker Compose运行
```bash
docker-compose up -d
```

### 3. 访问服务
- API网关: http://localhost:8080
- 商品服务: http://localhost:8081
- 订单服务: http://localhost:8082
- 用户服务: http://localhost:8083
- 支付服务: http://localhost:8084

## 部署说明
系统支持以下部署方式:
1. **Docker Compose**：适用于开发和测试环境
2. **Kubernetes**：适用于生产环境 (需额外配置)

## 文档
- [API文档](http://localhost:8080/swagger-ui.html) 

## 贡献
欢迎提交issue和pull request来改进系统。

## 许可证

本项目采用MIT许可证。
