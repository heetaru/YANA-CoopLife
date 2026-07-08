# YANA-CoopLife

## Overview

**Please note: This project is currently in the early stages of development. What you see here is just the beginning of a much larger vision.**

YANA-CoopLife is a backend service designed to handle cooperative task management and user interactions. 
Built with modern Java and Spring Boot, it lays the foundation for a platform where users can register, manage tasks, and potentially earn scores for their activities. 
The system is designed to be highly scalable, utilizing a clean RESTful approach and robust data validation.

## Features

* **User Management:** Secure user registration with strict data validation (name, email, and password constraints).
* **Task Tracking:** Users can create and manage personal or cooperative tasks linked directly to their accounts.
* **Score System Foundation:** A built-in scoring mechanism for users, paving the way for future gamification and reward features.
* **Global Exception Handling:** A unified error-handling mechanism that returns clean, readable JSON responses for missing entities or internal server errors.
* **API Documentation:** Integrated Springdoc OpenAPI (Swagger) for easy endpoint exploration and testing.

## Technologies

* **Language:** Java 21
* **Framework:** Spring Boot 4.1.0 (Spring WebMVC, Spring Data JPA)
* **Database:** PostgreSQL
* **Build Tool:** Gradle
* **Utilities:** Lombok, Hibernate Validator
* **Documentation:** OpenAPI / Swagger

## Architecture

The application follows a classic N-Tier (layered) architecture. It separates concerns into Controllers, Services, and Repositories. 
We use the DTO (Data Transfer Object) pattern along with custom mappers to ensure that internal database entities are never directly exposed to the client. 
The database layer interacts with PostgreSQL via Spring Data JPA, with Hibernate managing the schema updates automatically during this development phase.

## API

Here are the core REST endpoints currently available in the system:

  * GET /users — Retrieves a list of all registered users.
  * POST /users — Creates a new user account.
  * GET /users/{userId}/tasks — Fetches all tasks associated with a specific user.
  * POST /users/{userId}/tasks — Creates a new task for a specific user.
