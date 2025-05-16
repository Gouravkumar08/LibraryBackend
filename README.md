# 📚 Online Library Management System

This is a Backend for web application that allows users to manage a digital library. It includes:

- 📘 A **Spring Boot backend** with CRUD operations and integration with **Gemini API** to generate AI-powered book taglines/summaries.

---

## 🛠️ Tech Stack

| Layer     | Technology                  |
|-----------|-----------------------------|
| Frontend  | React.js, Tailwind CSS      |
| Backend   | Spring Boot, Spring Data JPA|
| Database  | H2 (in-memory)              |
| AI        | Gemini API (Gemini integration) |

---

## 📂 Project Structure

```
.
├── backend/                # Spring Boot backend
│   ├── src/main/java
│   ├── src/main/resources
│   ├── Dockerfile
│   └── pom.xml
│
```

---

## 📦 Backend (Spring Boot)

### ✅ Features

- Add, update, delete, search, and retrieve books
- Search by title and/or author
- Get AI-generated summaries/taglines using Gemini
- Proper input validation and exception handling
- H2 in-memory DB for testing

---

### ▶️ Running the Backend

#### 1. Clone and Navigate

```bash
git clone https://github.com/your-username/library-backend.git
cd library-backend
```

#### 2. Configure Gemini API Key

Add this in your `application.properties` or `application.yml`:

```properties
gemini.api.key=YOUR_GEMINI_API_KEY
```

#### 3. Start the Application

```bash
./mvnw spring-boot:run
```

---

## 🧪 API Endpoints

| Method | Endpoint                      | Description                    |
|--------|-------------------------------|--------------------------------|
| POST   | `/books`                      | Create a new book              |
| GET    | `/books`                      | List all books                 |
| GET    | `/books/{id}`                 | Get book by ID                 |
| PUT    | `/books/{id}`                 | Update a book                  |
| DELETE | `/books/{id}`                 | Delete a book                  |
| GET    | `/books/search?title=...`     | Search by title                |
| GET    | `/books/search?author=...`    | Search by author               |
| GET    | `/books/{id}/ai-insights`     | Get Gemini AI-generated summary|

