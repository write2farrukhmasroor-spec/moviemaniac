# MovieMania Microservice

A reactive microservice for managing movies, built with Spring Boot, GraphQL, and PostgreSQL (R2DBC). Supports movie details, genres, and cast information.

---

## Tech Stack

- **Backend:** Java 17, Spring Boot 3.x, WebFlux (Reactive)
- **Database:** PostgreSQL + R2DBC
- **API:** GraphQL (Spring GraphQL)
- **Data Migration:** Flyway
- **Monitoring:** Prometheus & Grafana
- **JSON Handling:** Jackson (for JSONB Cast)
- **Build Tool:** Gradle
- **Containerization:** Docker (PostgreSQL)

---

## Features

- CRUD operations for movies  
- `Genre` enum stored as integer, exposed as enum in API  
- `Cast` object stored as JSONB (actors & actresses)  
- Reactive non-blocking database access  
- GraphQL queries & mutations for movies  
- Flyway-managed DB migrations  

---

## Quick Start

1. Start PostgreSQL (Docker or local)  
2. Apply Flyway migrations  
3. Run application:

```bash
./gradlew bootRun

##Access graphql UI at
http://localhost:8080/graphiql
