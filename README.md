# Hotel-Booking-Management-System
Hotel Booking Management Application using Springboot and React JS


### Group 09
KUHDSE24.1F-02
KUHDSE24.1F-24
KUHDSE24.1F-27
KUHDSE24.1F-28

This project consists of a Spring Boot backend and a React frontend. The backend serves APIs, while the frontend provides a user interface.

## Prerequisites

- Java 21 
- Node.js
- MySQL
- npm (Node Package Manager)
- Maven (for Spring Boot)

## Running the Spring Boot Application (Server)

Navigate to the `Server` directory and run following commands:

   ```bash
   cd Server\BookingManagement
   ```
   ```
   mvn clean install
   ```
   ```
   mvn spring-boot:run
   ```

## Running the React Application (Fronend)

Navigate to the `Client` directory and run following commands:

```bash
cd Client\frontend
```
```
npm install
```
```
npm start
```

## To Start the MySQL Application

Install MySQL and Run the `Create_Database.sql` script to create the database.

## Create Admin user using Postman or any other API client bv specifying the role as `ADMIN`.
## If not run the following CURL for create Admin

```bash
curl -X POST http://localhost:8080/auth/register \
     -H "Content-Type: application/json" \
     -d '{"email": "admin@gmail.com", "password": "admin", "phoneNumber": "0712345678", "name": "Hotel Admin", "role": "ADMIN"}'

```

## If you are running CURL on Windows PowerShell use the below command

```bash
Invoke-WebRequest -Uri "http://localhost:8080/auth/register" `
    -Method POST `
    -Headers @{ "Content-Type" = "application/json" } `
    -Body '{"email": "admin@gmail.com", "password": "admin", "phoneNumber": "0712345678", "name": "Hotel Admin", "role": "ADMIN"}'

```


