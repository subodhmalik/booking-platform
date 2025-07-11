# 🎬 Booking Platform - Microservices Simulation

This is a **sample simulation** for a movie ticket **Booking Platform**, built with a modular monolith structure simulating a **microservices architecture**. Each module is independently runnable with its own in-memory database.

---

## 🧩 Modules Overview

### 1. 🎭 `theatre-service`
- Manages **theatre** and **screen** data.
- Allows adding theatres, locations, and their screens.

### 2. 🎬 `mv-show-service`
- Handles **movie** and **show** scheduling.
- Maps movies to screens with language and timing.

### 3. 💺 `booking-service`
- Manages **seat master data** and **booking operations**.
- Supports seat allocation, booking, and pricing.

### 4. 🌐 `metadata-service`
- Manages **language information** and **promotional offers**.

### 5. 🔄 `aggregator-service`
- A backend BFF (Backend for Frontend).
- Provides consolidated APIs for the frontend.
- Handles complex joins and orchestration between services.

### 6. 🚪 `gateway-service`
- Entry point for routing requests to various services (future extensibility).
- Based on Spring Cloud Gateway.

---

## ⚙️ Architecture

- Built using **Spring Boot** for each module.
- Each service uses **H2 in-memory database**.
- Services are completely **isolated**, simulating microservice boundaries.
- **OpenAPI (Swagger)** support enabled for API exploration.
- Communication between services handled using **RestTemplate**.

---

## 🚀 Getting Started

1. Clone the repo:
   ```bash
   git clone https://github.com/your-repo/booking-platform.git
   cd booking-platform
