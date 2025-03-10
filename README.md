
# Project Title

This is the backend for the Task Manager application, built with Spring Boot. It provides RESTful APIs to manage tasks, including creating, updating, deleting, and retrieving task details.

## Tech Stack

**Backend:** Java, Spring Boot, Spring Data JPA, MySQL, RESTful APIs, CORS Configuration

## Frontend Repository [Tasker-frontend](https://github.com/RisheekShukla/TaskManager_Angular)

## Features

- **Task Management**: Create, update, delete, and retrieve tasks.
- **Authentication & Authorization**: Secure endpoints using JWT-based authentication.
- **CORS Support**: Allows integration with frontend applications.


## Installation

Clone the repository:

```bash
  git clone https://github.com/RisheekShukla/TaskManager_SpringBoot
  cd tasker
```

Configure the database in application.properties:
```
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

Build and run the application:
```
mvn clean install
mvn spring-boot:run
```

## Contributing

Contributions are always welcome!

Feel free to contribute to the project by creating pull requests or reporting issues.


## License

[MIT](https://choosealicense.com/licenses/mit/)
