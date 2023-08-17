# NearbyUsersApp

NearbyUsersApp is a web-based application that facilitates finding the nearest users based on their locations. The application includes features for user management, location data storage, and retrieval of nearest users. It is built using the Spring Boot framework and utilizes an HSQL in-memory database for efficient data storage and retrieval.

## Tech Stack

- Java
- Spring Framework
- Spring Boot
- Spring Data JPA
- HSQLDB (In-Memory Database)
- Swagger UI
- Lombok
- Maven

## Modules

- User Management Module
- Location Module

## Features

### User Management

- Sign Up and Login: Users can sign up and log in to the application to access its features.

### Location Module

- Create Data: The application provides a REST API endpoint (`/create_data`) to create a table named 'user_location' in the database. The 'user_location' table includes fields for NAME, Latitude, Longitude, and excluded status.

- Update Data: The application exposes a REST API (`/update_data`) for updating the 'user_location' table.

- Get Nearest Users: Readers can call the REST API (`/get_users/N`) to retrieve the nearest N users from the location (0,0) who are not excluded.

## Installation & Run

Before running the API server, make sure to update the database configuration in the `application.properties` file located in the project root directory. Adjust the port number, username, and password according to your local database configuration.

```properties
server.port=8080

spring.datasource.url=jdbc:hsqldb:mem:testdb
spring.datasource.driver-class-name=org.hsqldb.jdbc.JDBCDriver
spring.datasource.username=sa
spring.datasource.password=
