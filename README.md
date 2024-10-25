# Rule Engine AST - Backend

Access the site here:- https://ruleengineast-frontend.onrender.com/

Welcome to the Rule Engine AST Backend! This is the backend component of the Rule Engine AST project, built using Spring Boot. It provides RESTful APIs for rule creation, combination, and evaluation using an Abstract Syntax Tree (AST) structure. The backend interacts with either MySQL or PostgreSQL databases for storing and retrieving rules.

## Technologies Used

- Java 17
- Spring Boot
- Maven
- MySQL (Local Development)
- PostgreSQL (Production Deployment on Render)
- Docker (Optional for containerized deployment)

## Table of Contents

1. Features
2. Prerequisites
3. Installation
4. Configuration
5. Running the Application
6. Building the Application
7. Docker
8. API Endpoints
9. Deployment
10. CORS Configuration

## Features

- Create new rules based on user-defined strings.
- Combine existing rules using logical operators (AND/OR).
- Evaluate rules against user data.
- Store rules as JSON-based AST in the database.
- RESTful APIs to manage all rule operations.

## Prerequisites

Before you begin, ensure you have the following installed:

- Java 17: [Download Java](https://adoptium.net/)
- Maven 3.x: [Download Maven](https://maven.apache.org/download.cgi)
- MySQL or PostgreSQL database: [MySQL](https://dev.mysql.com/downloads/) | [PostgreSQL](https://www.postgresql.org/download/)
- Docker (optional for containerized deployment): [Install Docker](https://www.docker.com/products/docker-desktop/)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/RuleEngineAST-Backend.git
   cd RuleEngineAST-Backend
   ```

2. Install dependencies:
   ```bash
   mvn clean install
   ```

### Database Configuration

#### MySQL Configuration (Local Development)
To set up the MySQL database for local development, modify the `application.properties` file located in `src/main/resources/`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ruleengineast
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
```

#### PostgreSQL Configuration (Production)
For the production environment, PostgreSQL is used. Modify the `application.properties` file accordingly or use environment variables for sensitive data:

```properties
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

## Running the Application

To run the backend locally, use the following command:

```bash
mvn spring-boot:run
```

Once running, the backend will be available at [http://localhost:8080](http://localhost:8080).

## Building the Application

To build a JAR file, run the following command:

```bash
mvn clean package
```

The JAR will be generated in the `target/` directory.

## Docker

You can containerize the backend using the provided Dockerfile.

### Build Docker Image

To build the Docker image:

```bash
docker build -t rule-engine-backend .
```

### Run Docker Container

To run the Docker container:

```bash
docker run -p 8080:8080 rule-engine-backend
```

## API Endpoints

### 1. Create Rule
**URL**: `/rules/create`  
**Method**: `POST`  
**Description**: Create a new rule.  

**Example Request**:
```json
{
  "ruleName": "Rule 1",
  "ruleString": "age > 30"
}
```

### 2. Combine Rules
**URL**: `/rules/combine`  
**Method**: `POST`  
**Description**: Combine two existing rules.  

**Example Request**:
```json
{
  "ruleId1": 1,
  "ruleId2": 2,
  "operator": "AND"
}
```

### 3. Evaluate Rule
**URL**: `/rules/evaluate`  
**Method**: `POST`  
**Description**: Evaluate a rule against user data.  

**Example Request**:
```json
{
  "ruleId": 1,
  "userData": {
    "age": 35,
    "salary": 60000
  }
}
```

## CORS Configuration

To enable CORS for the frontend deployed on Render, add the following configuration:

```java
registry.addMapping("/**")
    .allowedOrigins("https://ruleengineast-frontend.onrender.com")
    .allowedMethods("GET", "POST", "PUT", "DELETE");
```

## Deployment

The backend is deployed on [Render](https://render.com/) using PostgreSQL for the production environment.

- Local Development: Uses MySQL for database operations.
- Production: Uses PostgreSQL for scalable and robust database management.

Feel free to reach out for any queries or issues!

--- 
