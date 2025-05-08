# Book Management API

## Overview
The Book Management API allows users to add, search, and manage books through a simple and intuitive RESTful interface. This API provides an easy way to interact with a book database, supporting functionality like adding new books, searching for books by various criteria, and retrieving book details.

## Features
- Add new books to the database
- Search for books by title, author, genre, and other filters
- Retrieve detailed information about specific books
- Easy-to-use Swagger interface for testing and interacting with the API

## Technologies Used
- **Backend Framework**: Spring Boot
- **Database**: [Your Database Choice, e.g., MySQL, PostgreSQL, etc.]
- **Documentation**: Swagger for API documentation

## Endpoints

### `POST /books`
Add a new book to the database.

#### Request Body
```json
{
  "title": "Book Title",
  "author": "Book Author",
  "genre": "Book Genre",
  "publishedYear": 2025
}
```

#### Response
```json
{
  "id": 1,
  "title": "Book Title",
  "author": "Book Author",
  "genre": "Book Genre",
  "publishedYear": 2025
}
```

### `GET /books`
Retrieve a list of books in the database with optional query parameters.

#### Query Parameters
- `title`: Filter by book title
- `author`: Filter by author name
- `genre`: Filter by genre

#### Response
```json
[
  {
    "id": 1,
    "title": "Book Title",
    "author": "Book Author",
    "genre": "Book Genre",
    "publishedYear": 2025
  },
  ...
]
```

### `GET /books/{id}`
Retrieve detailed information about a specific book by its ID.

#### Response
```json
{
  "id": 1,
  "title": "Book Title",
  "author": "Book Author",
  "genre": "Book Genre",
  "publishedYear": 2025
}
```

## Running the API Locally

### Prerequisites
- JDK 11 or higher
- Maven or Gradle
- Your preferred database setup (e.g., MySQL, PostgreSQL)

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/bookapi.git
   cd bookapi
   ```

2. Configure your database connection in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/bookdb
   spring.datasource.username=root
   spring.datasource.password=password
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. The API will be available at `http://localhost:8080`.

## Swagger Documentation
You can access the Swagger UI at `http://localhost:8080/swagger-ui.html` to interact with the API and explore its endpoints.

## Contributing
Feel free to fork the repository, create a branch, and submit a pull request with your improvements or fixes.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
