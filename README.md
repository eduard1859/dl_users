
# API Users
/home/carlosrodriguez/java21/README.md
Welcome to the **API Users** project! This RESTful API allows you to register users and manage their contact information securely. Upon registration, a JWT token is generated for the user, which can be used to access protected APIs.

## Requirements

- **Java:** Version 21
- **Maven:** Version 3.9 or higher
- **Spring Boot:** Version 3.4.0
- **Database:** In-memory H2 database
- **IDE:** Any code editor like Visual Studio Code, IntelliJ IDEA, or Eclipse

## Getting Started

### Clone the Repository

First, clone the repository to your local machine:

```bash
git clone https://github.com/eduard1859/dl_users.git
cd api_users
```

### Build and Run the Application

To build and run the application locally, use the following Maven commands:

```bash
mvn clean install
mvn spring-boot:run
```

### Access the H2 Database Console

You can access the H2 console to inspect the database and run SQL queries:

- **URL:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
- **User:** `SA`
- **Password:** (Leave blank)

### Access the Swagger UI

Explore and interact with the API endpoints using the Swagger UI:

- **URL:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

## Configuration

### Password Validation

Configure the regular expression for password validation in the `application.properties` file:

```properties
password.validation.regex=^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$
```

## How It Works

This API provides a service for user registration. Users can register themselves and their contact information. Upon successful registration, a JWT token is generated, which can be used to access various protected APIs that require JWT authentication.

## Example Requests

### Register a User

```http
POST /api/users/register
Content-Type: application/json

{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "password": "P@ssw0rd!",
  "phones": [
    {
      "number": "1234567890",
      "cityCode": "1",
      "countryCode": "44"
    }
  ]
}
```

### Response

```json
{
  "id": "cd9981de-3954-44f8-a375-ca0071d4a548",
  "name": "carlos eduardo",
  "email": "usuario@dominio.com",
  "password": "P@ssw0rd!",
  "phones": [
    {
      "number": "123456",
      "cityCode": "9",
      "countryCode": "+56"
    }
  ],
  "created": "2024-08-30T11:29:15.890942200",
  "modified": "2024-08-30T11:29:15.890998929",
  "lastLogin": "2024-08-30T11:29:15.891006172",
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c3VhcmlvQGRvbWluaW8uY29tIiwiaWF0IjoxNzI1MDMxNzU1LCJleHAiOjE3MjUwMzUzNTV9.qQmdmcDc34cGz7IBx0fGPKYsG-a487J7GrSB-VV2vD8eOwLUIZ7NkhsCaTLuOj6C-P72i0Jla_3Wnk14a3zkDQ",
  "active": true
}
```

