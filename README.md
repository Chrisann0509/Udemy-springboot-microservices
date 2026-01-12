## 🚀 Project Startup Guide

### 1️⃣ Create Required Databases

Run the following SQL commands:

```sql
CREATE DATABASE employee_db;
CREATE DATABASE department_db;
CREATE DATABASE organization_db;
```

### 2️⃣ Run RabbitMQ (Spring Cloud Bus)

Start RabbitMQ using Docker:

```bash
docker run --rm -it -p 5672:5672 rabbitmq:3.11.0
```

* **Port:** `5672`
* Used for **Spring Cloud Bus messaging**

### 3️⃣ Start Zipkin (Distributed Tracing)

Run Zipkin using Docker:

```bash
docker run --rm -it --name zipkin -p 9411:9411 openzipkin/zipkin
```

* **UI URL:** [http://localhost:9411](http://localhost:9411)
* Used for **distributed tracing and monitoring**

### 4️⃣ Service Startup Sequence

Start the Spring Boot services **in the following order**:

1. **service-registry**

   * Eureka Server
   * Must be started first so other services can register

2. **config-server**

   * Provides centralized configuration for all services

3. **api-gateway**

   * Entry point for all client requests

4. **organization-service**

   * Core business service

5. **department-service**

   * Depends on organization-service

6. **employee-service**

   * Depends on department-service and organization-service

⚠️ **Important:**
Ensure each service has started successfully before proceeding to the next one.

✅ Once all steps are completed, you can proceed to start the application services.
