# 🏥 Patient Management Service

Practice project based on: **Build & Deploy a Production-Ready Patient Management System with Microservices: Java Spring Boot AWS**.

---

## 🛠️ Tech Stack & Dependencies

- **Language**: Java 21
- **Framework**: Spring Boot 4.1.1
- **Persistence**: Spring Data JPA, Hibernate ORM 7
- **Database**:
  - Development: In-Memory H2 Database
  - Production (Ready): PostgreSQL
- **Validation**: Jakarta Bean Validation
- **Build Tool**: Apache Maven (Maven Wrapper included)
- **Default Port**: `4000`

---

## 📂 Project Architecture

```
patient-management/
├── api-requests/
│   └── patient-service/               # HTTP client test requests
│       ├── create-patient.http
│       ├── delete-patient.http
│       ├── get-patients.http
│       └── update-patient.http
└── patient-service/
    ├── pom.xml                        # Maven dependencies & build configuration
    └── src/
        ├── main/
        │   ├── java/com/pm/patientservice/
        │   │   ├── controller/         # REST Controllers (Presentation Layer)
        │   │   │   └── PatientController.java
        │   │   ├── service/            # Business Logic Layer
        │   │   │   └── PatientService.java
        │   │   ├── repository/         # Spring Data JPA Repositories (Data Access Layer)
        │   │   │   └── PatientRepository.java
        │   │   ├── model/              # JPA Domain Entities
        │   │   │   └── Patient.java
        │   │   ├── dto/                # Data Transfer Objects & Validation Groups
        │   │   │   ├── PatientRequestDTO.java
        │   │   │   ├── PatientResponseDTO.java
        │   │   │   └── validators/
        │   │   │       └── CreatePatientValidationGroup.java
        │   │   ├── mapper/             # Entity <-> DTO Mappers
        │   │   │   └── PatientMapper.java
        │   │   ├── exception/          # Global Exception Handling
        │   │   │   ├── GlobalExceptionHandler.java
        │   │   │   ├── EmailAlreadyExistsException.java
        │   │   │   └── PatientNotFoundException.java
        │   │   └── PatientServiceApplication.java
        │   └── resources/
        │       ├── application.properties
        │       └── data.sql            # Seed dataset (15 initial patients)
        └── test/
            └── java/com/pm/patientservice/
                └── PatientServiceApplicationTests.java
```

---

## ⚡ Getting Started

### Prerequisites
- **JDK 21** or later
- Git

### Installation & Run

1. Navigate to the `patient-service` directory:
   ```bash
   cd patient-service
   ```

2. Run the application using the Maven wrapper:
   ```bash
   ./mvnw spring-boot:run
   ```

3. The service will be up and running on:
   ```
   http://localhost:4000
   ```

### 🗄️ H2 Database Console
The in-memory database web console is enabled for easy data inspection:
- **URL**: `http://localhost:4000/h2-console`
- **Driver Class**: `org.h2.Driver`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **User Name**: `admin_viewer`
- **Password**: `password`
