# sparklehood
AI Safety Incident Log API
A simple RESTful API built with Java 17, Spring Boot, and MySQL to log and manage AI safety incidents.

Features
Log new AI safety incidents

View all incidents or a specific incident by ID

Delete incidents

Data validation and error handling

Tech Stack
Java 17

Spring Boot

Spring Data JPA (Hibernate)

MySQL

Getting Started
1. Clone the Repository
text
git clone <your-repo-url>
cd <your-project-folder>
2. Create the MySQL Database
Open MySQL Workbench and run:

sql
CREATE DATABASE ai_safety_db;
USE ai_safety_db;

CREATE TABLE Incident (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    severity VARCHAR(10) NOT NULL CHECK (severity IN ('LOW', 'MEDIUM', 'HIGH')),
    reportedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);
3. Configure Database Credentials
Edit src/main/resources/application.properties:

text
spring.datasource.url=jdbc:mysql://localhost:3306/ai_safety_db
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8080
4. Build and Run the Application
text
./mvnw spring-boot:run
The app will start at http://localhost:8080.

API Endpoints
Method	Endpoint	Description
GET	/incidents	Get all incidents
POST	/incidents	Create a new incident
GET	/incidents/{id}	Get an incident by ID
DELETE	/incidents/{id}	Delete an incident by ID
Example: Create Incident
text
curl -X POST http://localhost:8080/incidents \
-H "Content-Type: application/json" \
-d '{
  "title": "Unauthorized Data Access",
  "description": "AI system accessed restricted data.",
  "severity": "HIGH"
}'
Example: Get All Incidents
text
curl http://localhost:8080/incidents
Project Structure
text
src/main/java/com/SPARKLEHOOD/SPARKLEHOOD/
    ├── SparklehoodApplication.java
    ├── controller/
    │     └── IncidentController.java
    ├── model/
    │     └── Incident.java
    ├── repository/
    │     └── IncidentRepository.java
    └── service/
          └── IncidentService.java
src/main/resources/
    └── application.properties
Notes
Ensure MySQL is running and accessible.

Default port is 8080. Change in application.properties if needed.

All timestamps are in UTC.

License
MIT (or your chosen license)

Inspired by best practices from [Spring Boot MySQL REST API Tutorials].

You can copy, edit, and use this README.md in your project root!

give me in txt formate for github
give me in txt formate for github

Answer

Images
image.jpg
Here’s a README.md in plain text format, ready to copy-paste into your GitHub project:

text
# AI Safety Incident Log API

A RESTful API built with Java 17, Spring Boot, and MySQL to log and manage AI safety incidents.

---

## Features

- Log new AI safety incidents
- View all incidents or a specific incident by ID
- Delete incidents
- Data validation and error handling

---

## Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA (Hibernate)
- MySQL

---

## Getting Started

### 1. Clone the Repository

git clone <your-repo-url>
cd <your-project-folder>

text

### 2. Create the MySQL Database

Open MySQL Workbench and run:

CREATE DATABASE ai_safety_db;
USE ai_safety_db;

CREATE TABLE Incident (
id BIGINT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR(255) NOT NULL,
description TEXT NOT NULL,
severity VARCHAR(10) NOT NULL CHECK (severity IN ('LOW', 'MEDIUM', 'HIGH')),
reportedAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

text

### 3. Configure Database Credentials

Edit `src/main/resources/application.properties`:

spring.datasource.url=jdbc:mysql://localhost:3306/ai_safety_db
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
server.port=8080

text

### 4. Build and Run the Application

./mvnw spring-boot:run

text

The app will start at [http://localhost:8080](http://localhost:8080).

---

## API Endpoints

| Method | Endpoint             | Description                  |
|--------|----------------------|------------------------------|
| GET    | `/incidents`         | Get all incidents            |
| POST   | `/incidents`         | Create a new incident        |
| GET    | `/incidents/{id}`    | Get an incident by ID        |
| DELETE | `/incidents/{id}`    | Delete an incident by ID     |

### Example: Create Incident

curl -X POST http://localhost:8080/incidents
-H "Content-Type: application/json"
-d '{
"title": "Unauthorized Data Access",
"description": "AI system accessed restricted data.",
"severity": "HIGH"
}'

text

### Example: Get All Incidents

curl http://localhost:8080/incidents

text

---

## Project Structure

src/main/java/com/SPARKLEHOOD/SPARKLEHOOD/
├── SparklehoodApplication.java
├── controller/
│ └── IncidentController.java
├── model/
│ └── Incident.java
├── repository/
│ └── IncidentRepository.java
└── service/
└── IncidentService.java
src/main/resources/
└── application.properties

text

---

## Notes

- Ensure MySQL is running and accessible.
- Default port is `8080`. Change in `application.properties` if needed.
- All timestamps are in UTC.

---

## License

MIT (or your chosen license)
