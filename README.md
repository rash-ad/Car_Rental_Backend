# 🚗 Car Rental REST API

<div align="center">

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-ORM-59666C?style=for-the-badge&logo=hibernate&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

**A production-ready RESTful backend for a Car Rental Management System**  
Built with Spring Boot, Hibernate ORM, and MySQL

[Features](#-features) · [Tech Stack](#-tech-stack) · [Getting Started](#-getting-started) · [API Docs](#-api-endpoints) · [Database](#-database-schema) · [Contributing](#-contributing)

</div>

---

## 📌 Overview

The **Car Rental REST API** is a fully functional backend service that handles the core operations of a car rental business — managing vehicles, customers, bookings, and payments through clean, well-structured RESTful endpoints.

This project follows layered architecture (Controller → Service → Repository → Entity) and is designed with real-world enterprise patterns in mind, making it an ideal portfolio piece for backend engineering roles.

---

## ✨ Features

- 🚗 **Vehicle Management** — Add, update, list, and remove rental cars with availability status
- 👤 **Customer Management** — Register and manage customer profiles
- 📅 **Booking System** — Create and manage car rentals with date validation and conflict detection
- 💳 **Payment Tracking** — Record and query payment status per booking
- 🔍 **Search & Filter** — Filter cars by availability, type, and date range
- ⚠️ **Global Exception Handling** — Consistent error responses across all endpoints
- 🗄️ **Hibernate ORM** — Clean entity mappings with relationship management
- 📄 **RESTful Design** — Follows REST conventions with proper HTTP status codes

---

## 🛠 Tech Stack

| Layer | Technology |
|---|---|
| Language | Java 17 |
| Framework | Spring Boot 3.x |
| ORM | Hibernate (via Spring Data JPA) |
| Database | MySQL 8.0 |
| Build Tool | Maven |
| API Style | REST (JSON) |
| Validation | Spring Boot Validation (Jakarta) |
| Dev Tool | Spring Boot DevTools |

---

## 📁 Project Structure

```
src/
└── main/
    ├── java/
    │   └── edu/icet/ecom/
    │       ├── controller/         # REST Controllers (API layer)
    │       │   ├── CarController.java
    │       │   ├── CustomerController.java
    │       │   ├── BookingController.java
    │       │   └── PaymentController.java
    │       ├── service/            # Business logic layer
    │       │   ├── CarService.java
    │       │   ├── CustomerService.java
    │       │   ├── BookingService.java
    │       │   └── PaymentService.java
    │       ├── repository/         # Spring Data JPA repositories
    │       │   ├── CarRepository.java
    │       │   ├── CustomerRepository.java
    │       │   ├── BookingRepository.java
    │       │   └── PaymentRepository.java
    │       ├── entity/             # Hibernate entity classes
    │       │   ├── Car.java
    │       │   ├── Customer.java
    │       │   ├── Booking.java
    │       │   └── Payment.java
    │       ├── dto/                # Data Transfer Objects
    │       │   ├── CarDto.java
    │       │   ├── BookingDto.java
    │       │   └── PaymentDto.java
    │       ├── exception/          # Global exception handling
    │       │   ├── GlobalExceptionHandler.java
    │       │   └── ResourceNotFoundException.java
    │       └── CarRentalApplication.java
    └── resources/
        └── application.yml
```

---

## ⚡ Getting Started

### Prerequisites

- Java 17+
- MySQL 8.0+
- Maven 3.x
- IDE: IntelliJ IDEA / Eclipse / VS Code

### 1. Clone the Repository

```bash
git clone https://github.com/rash-ad/car-rental-api.git
cd car-rental-api
```

### 2. Set Up the Database

Create a MySQL database:

```sql
CREATE DATABASE car_rental_db;
```

### 3. Configure `application.properties`

```properties
# Server
server.port=8080

# Database
spring.datasource.url=jdbc:mysql://localhost:3306/car_rental_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

# Hibernate / JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.properties.hibernate.format_sql=true
```

### 4. Build & Run

```bash
mvn clean install
mvn spring-boot:run
```

The server starts at: **`http://localhost:8080`**

---

## 📡 API Endpoints

### 🚗 Car Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/v1/cars` | Get all cars |
| `GET` | `/api/v1/cars/{id}` | Get car by ID |
| `GET` | `/api/v1/cars/available` | Get available cars |
| `POST` | `/api/v1/cars` | Add a new car |
| `PUT` | `/api/v1/cars/{id}` | Update car details |
| `DELETE` | `/api/v1/cars/{id}` | Remove a car |

### 👤 Customer Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/v1/customers` | Get all customers |
| `GET` | `/api/v1/customers/{id}` | Get customer by ID |
| `POST` | `/api/v1/customers` | Register a new customer |
| `PUT` | `/api/v1/customers/{id}` | Update customer info |
| `DELETE` | `/api/v1/customers/{id}` | Delete a customer |

### 📅 Booking Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/v1/bookings` | Get all bookings |
| `GET` | `/api/v1/bookings/{id}` | Get booking by ID |
| `GET` | `/api/v1/bookings/customer/{customerId}` | Get bookings by customer |
| `POST` | `/api/v1/bookings` | Create a new booking |
| `PUT` | `/api/v1/bookings/{id}/cancel` | Cancel a booking |

### 💳 Payment Endpoints

| Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/v1/payments/{bookingId}` | Get payment for a booking |
| `POST` | `/api/v1/payments` | Record a payment |
| `PUT` | `/api/v1/payments/{id}/status` | Update payment status |

---

## 🧪 Sample Request & Response

### Create a Booking — `POST /api/v1/bookings`

**Request Body:**
```json
{
  "customerId": 1,
  "carId": 3,
  "startDate": "2025-07-01",
  "endDate": "2025-07-05"
}
```

**Response `201 Created`:**
```json
{
  "bookingId": 12,
  "customerId": 1,
  "carId": 3,
  "startDate": "2025-07-01",
  "endDate": "2025-07-05",
  "totalCost": 25000.00,
  "status": "CONFIRMED"
}
```

---

## 🗄️ Database Schema

```
customers          cars
──────────         ──────────
id (PK)            id (PK)
full_name          brand
email              model
phone              license_plate
license_no         daily_rate
created_at         status (AVAILABLE / RENTED)
                   year

bookings           payments
──────────         ──────────
id (PK)            id (PK)
customer_id (FK)   booking_id (FK)
car_id (FK)        amount
start_date         payment_date
end_date           payment_method
total_cost         status (PAID / PENDING)
status
```

---

## 🔧 Dependencies (`pom.xml`)

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
</dependencies>
```

---

## 🚀 Roadmap

- [ ] JWT Authentication & Role-based access (Admin / Customer)
- [ ] Swagger / OpenAPI documentation
- [ ] Email notification on booking confirmation
- [ ] Pagination & sorting on list endpoints
- [ ] Docker support
- [ ] Unit & integration tests with JUnit 5 + Mockito

---

## 👨‍💻 Author

**Rashad**  
Full-Stack Software Engineering Student | ICET  
📍 Malwana, Sri Lanka  
🔗 [GitHub](https://github.com/rash-ad)

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

<div align="center">
  <sub>Built with ☕ Java and 🌱 Spring Boot</sub>
</div>
