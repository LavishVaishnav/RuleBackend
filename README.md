# 🌐 Rule Engine AST - Backend

Welcome to the **Rule Engine AST Backend**! This is the backend component of the Rule Engine AST project, built using **Spring Boot**. It provides RESTful APIs for rule creation, combination, and evaluation using an **Abstract Syntax Tree (AST)** structure. The backend interacts with either **MySQL** or **PostgreSQL** databases for storing and retrieving rules.

<div align="center">
  <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" alt="Java 17"/>
  <img src="https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white" alt="Maven"/>
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL"/>
  <img src="https://img.shields.io/badge/PostgreSQL-4169E1?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL"/>
  <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" alt="Docker"/>
</div>

---

## 📋 Table of Contents
- [✨ Features](#-features)
- [⚙️ Prerequisites](#-prerequisites)
- [🔧 Installation](#-installation)
- [🔑 Configuration](#-configuration)
- [🚀 Spring Boot Application](#-spring-boot-application)
- [📡 API Endpoints](#-api-endpoints)
- [🛠 Running the Application](#-running-the-application)
- [🏗 Building the Application](#-building-the-application)
- [🐳 Docker](#-docker)
- [🌍 Deployment](#-deployment)

---

## ✨ Features

- 📝 **Create** new rules based on user-defined strings.
- 🔗 **Combine** existing rules using logical operators (AND/OR).
- 📊 **Evaluate** rules against user data.
- 🗄 **Store** rules as JSON-based AST in the database.
- 📡 RESTful APIs to manage all rule operations.

---

## ⚙️ Prerequisites

Before you begin, ensure you have the following installed:

- ☕ **Java 17**: [Download Java](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- 🔨 **Maven 3.x**: [Download Maven](https://maven.apache.org/download.cgi)
- 🗄 **MySQL** or **PostgreSQL** database: [MySQL](https://www.mysql.com/) | [PostgreSQL](https://www.postgresql.org/)
- 🐳 **Docker** (optional for containerized deployment): [Install Docker](https://docs.docker.com/get-docker/)

---

## 🔧 Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/your-username/RuleEngineAST-Backend.git
   cd RuleEngineAST-Backend

   
Install dependencies:
mvn clean install


## Database Configuration

### MySQL Configuration (Local Development)
To set up the MySQL database for local development, modify the `application.properties` file located in `src/main/resources/`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ruleengineast
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update

##PostgreSQL Configuration (Production)
###For the production environment, you can set up PostgreSQL using the following properties. It's recommended to use environment variables for sensitive data like URL, username, and password:

spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect




---
 ##  CORS Configuration

registry.addMapping("/**")
    .allowedOrigins("https://ruleengineast-frontend.onrender.com")
    .allowedMethods("GET", "POST", "PUT", "DELETE");


📡 API Endpoints
1. Create Rule
URL: /rules/create
Method: POST
Description: Create a new rule.
Example Request:


{
  "ruleName": "Rule 1",
  "ruleString": "age > 30"
}
2. Combine Rules
URL: /rules/combine
Method: POST
Description: Combine two existing rules.
Example Request:


{
  "ruleId1": 1,
  "ruleId2": 2,
  "operator": "AND"
}
3. Evaluate Rule
URL: /rules/evaluate
Method: POST
Description: Evaluate a rule against user data.
Example Request:


{
  "ruleId": 1,
  "userData": {
    "age": 35,
    "salary": 60000
  }
}
🛠 Running the Application
To run the backend locally, use the following command:


mvn spring-boot:run
Once running, the backend will be available at http://localhost:8080.

🏗 Building the Application
To build a JAR file, run the following command:


mvn clean package
The JAR will be generated in the target/ directory.

🐳 Docker
You can containerize the backend using the provided Dockerfile.

Build Docker Image
To build the Docker image:


docker build -t rule-engine-backend .
Run Docker Container
To run the Docker container:


docker run -p 8080:8080 rule-engine-backend

