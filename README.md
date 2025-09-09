🚀 Microservices Communication Practice

This project is a hands-on practice of building microservices communication patterns using Spring Boot, focusing on both synchronous and asynchronous approaches.

📌 Features

Monorepo Setup – All services are maintained in a single repository for easier dependency management and version control.

Synchronous Communication

Implemented using RestTemplate (basic approach).

Implemented using Feign Client (cleaner and more maintainable approach).

Asynchronous Communication

Implemented using Apache Kafka for producer–consumer messaging.

Implemented using Spring Application Events (ApplicationEventPublisher + @EventListener) for in-process async communication.

Best Practices Followed

DTOs for request/response payloads.

Event-driven design with Spring events and Kafka.

Exception handling with custom exceptions.

Service and repository layer separation.

MapStruct for clean object mapping.

Lombok for reducing boilerplate code.

🛠️ Tech Stack

Java 17

Spring Boot

Spring Web

Spring Kafka

Feign Client

RestTemplate

Spring Application Events

Lombok

MapStruct

Docker (for Kafka broker setup)

⚡ Communication Types

🔹 Synchronous (Request/Response)

RestTemplate – Traditional HTTP client for inter-service calls.

Feign Client – Declarative HTTP client that simplifies communication between services.

🔹 Asynchronous (Event-driven)

Kafka Producer/Consumer – For inter-service async communication.

Spring Application Events – For in-process async communication inside a service.
