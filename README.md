# Employee Management Application

Welcome to the Employee Management System! This application simplifies the task of managing employee details using Spring Boot, Thymeleaf, and MongoDB. It allows you to add, update, delete, and search for employees by their ID.

## Features

- **Add Employee:** Register a new employee with details such as Employee ID, Name, Email, Job Location, Department, and Address.
- **View Employees:** See a list of all registered employees.
- **Update Employee:** Modify existing employee details.
- **Delete Employee:** Remove an employee from the system.
- **Search Employee:** Find employees by their Employee ID.

## Technologies Used

- **Spring Boot:** Backend REST APIs.
- **Thymeleaf:** Frontend views.
- **MongoDB:** Database for storing employee data.
- **Maven:** Project management and dependencies.
- **Lombok:** Reduces boilerplate code.

## Prerequisites

- Java 17
- Maven
- MongoDB

## Installation

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/employee-management-system.git
   cd employee-management-system
Configure MongoDB:
Update the MongoDB URI in application.yml:

yaml
Copy code
spring:
  data:
    mongodb:
      uri: "your-mongodb-uri"

      
Build and Run the application:

bash
Copy code
mvn clean install
mvn spring-boot:run


Usage:
Access the application: Open your browser and go to http://localhost:8080.
Home Page: Options to add, display, and search for staff by ID.
Add Staff: Fill in the form to register a new employee.
Display Staff Details: View all employees with options to update or delete each entry.
Search: Enter an Employee ID to find specific employee details.
