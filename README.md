🚀 Microservices Communication Practice

This project is a hands-on practice of building microservices communication patterns using Spring Boot, focusing on both synchronous and asynchronous approaches.

📌 Features

Monorepo Setup – All services are maintained in a single repository for easier dependency management and version control.
Synchronous Communication
Implemented using RestTemplate (basic approach).
Implemented using Feign Client (cleaner and more maintainable approach).
Asynchronous Communication
Implemented using Apache Kafka for producer–consumer messaging.
Demonstrates decoupled service communication with high scalability.
Best Practices Followed
DTOs for request/response payloads.
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
Lombok
MapStruct
Docker (for Kafka broker setup)

⚡ Communication Types
🔹 Synchronous (Request/Response)

RestTemplate – Traditional HTTP client for inter-service calls.
Feign Client – Declarative HTTP client that simplifies communication between services.

🔹 Asynchronous (Event-driven)

Kafka Producer – Publishes events to Kafka topics.
Kafka Consumer – Subscribes and processes events asynchronously.
