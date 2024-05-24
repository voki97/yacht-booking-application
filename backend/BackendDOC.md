# Yacht Booking Application Backend Documentation

Welcome to the documentation for the backend of the Yacht Booking Application. This document provides an overview of the backend structure, components, endpoints, and setup instructions.

## Project Structure

The backend of the Yacht Booking Application follows a standard Spring Boot project structure:

- **database**
   - create_tables.sql — sql script to generate the database. More about can be found in [database documentation](database/DatabaseDOC.md).
   - setup_database.sh — script for generating the database.
- **src**
   - **main**
      - **java**
         - **com.example.yachtbookingapp**
            - **controller**
               - BookingController
               - ControllerDOC.md
               - DiscountController
               - ReportController
               - YachtController
            - **model**
               - BookingEntityModel
               - DiscountEntityModel
               - EntityModelDOC.md
               - ReportEntityModel
               - YachtEntityModel
               - bookingDiscount
                  - BookingDiscount
                  - BookingDiscountKey
               - DTOs
                  - CalculateTotalPriceRequest
                  - CreateBookingRequest
            - **repository**
               - BookingRepository
               - DiscountRepository
               - ReportRepository
               - YachtRepository
            - **service**
               - BookingService
               - DiscountService
               - ReportService
               - ServiceDOC.md
               - YachtService
            - YachtBookingAppApplication
      - **resources**
         - application.properties

## Components

The backend of the Yacht Booking Application consists of the following components:

- **Controllers**: Handle incoming HTTP requests, process the requests, and return appropriate HTTP responses. They define RESTful API endpoints for interacting with the application. More about controllers is described in [ControllerDOC](src/main/java/com/example/yachtbookingapp/controller/ControllerDOC.md).

- **Models**: Define entity classes representing domain objects such as yachts, bookings, discounts and reports. These classes are typically annotated with JPA annotations for database mapping. More about entity models is described in [EntityModelDOC](src/main/java/com/example/yachtbookingapp/model/EntityModelDOC.md).

- **Repositories**: Provide interfaces for interacting with the database using Spring Data JPA. They extend `JpaRepository`.

- **Services**: Contain business logic and perform operations such as booking a yacht, applying discounts, generating reports. They typically interact with repositories to access and manipulate data. More about services is described in [ServiceDOC](src/main/java/com/example/yachtbookingapp/service/ServiceDOC.md).

## Setup and Installation

To set up and run the backend of the Yacht Booking Application locally, follow these steps:

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/voki97/yacht-booking-app.git
   cd yacht-booking-app
   cd backend

2. MySQL Installation (for Users Without MySQL Installed):

   If you don't have MySQL installed on your system, you can follow these instructions to install it using Homebrew (recommended):

   1. **Open Terminal**: Launch the Terminal application on your macOS system.

   2. **Install Homebrew**: If you haven't already installed Homebrew, run the following command in the Terminal:
      ```bash
      /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   3. **Install MySql**: If you haven't already installed MySql, run the following command in the Terminal:
         ```bash
         brew install mysql
   
3. Run the [script](database/setup_database.sh) to create database, tables and data examples. 
4. **Run MySql**
   ```bash
   mysql -u root -p
If not changed, enter password(default): password
