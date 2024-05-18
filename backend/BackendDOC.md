# Yacht Booking Application Backend Documentation

Welcome to the documentation for the backend of the Yacht Booking Application. This document provides an overview of the backend structure, components, endpoints, and setup instructions.

## Project Structure

The backend of the Yacht Booking Application follows a standard Spring Boot project structure:

yacht-booking-backend/<br>
│<br>
├── src/<br>
│ ├── main/<br>
│ │ ├── java/ # Java source files<br>
│ │ │ └── com/<br>
│ │ │ └── example/<br>
│ │ │ └── yachtbookingapp/<br>
│ │ │ ├── controller/ # REST controllers<br>
│ │ │ ├── model/ # Entity classes<br>
│ │ │ ├── repository/ # Spring Data JPA repositories<br>
│ │ │ ├── service/ # Service classes<br>
│ │ │ └── YachtBookingApplication.java # Main application class<br>
│ │ └── resources/ # Resource files (application.properties, etc.)<br>
│ └── test/ # Unit and integration tests<br>
│<br>
├── target/ # Compiled bytecode and build artifacts<br>
└── ...<br>

## Components

The backend of the Yacht Booking Application consists of the following components:

- **Controllers**: Handle incoming HTTP requests, process the requests, and return appropriate HTTP responses. They define RESTful API endpoints for interacting with the application.

- **Models**: Define entity classes representing domain objects such as yachts, bookings, and discounts. These classes are typically annotated with JPA annotations for database mapping. More about entity models is described in [EntityModelDOC](src/main/java/com/example/yachtbookingapp/model/EntityModelDOC.md).

- **Repositories**: Provide interfaces for interacting with the database using Spring Data JPA. They extend `JpaRepository`.

- **Services**: Contain business logic and perform operations such as booking a yacht, applying discounts, generating reports. They typically interact with repositories to access and manipulate data. More about services is described in [ServiceDOC](src/main/java/com/example/yachtbookingapp/service/ServiceDOC.md).

# Yacht Booking Application Database Documentation

## Overview

This document provides an overview of the database schema for the Yacht Booking Application. The schema consists of several tables to manage yachts, bookings, discounts, and reports.

## Tables

### 1. Yacht Table

- **yacht_id**: Unique identifier for each yacht (Primary Key).
- **name**: Name of the yacht.
- **type**: Type of the yacht.
- **price_per_day**: Price per day for renting the yacht.

### 2. Booking Table

- **booking_id**: Unique identifier for each booking (Primary Key).
- **yacht_id**: Foreign Key referencing the Yacht Table.
- **booking_date**: Date and time when the booking was made.
- **start_date**: Start date of the booking.
- **end_date**: End date of the booking.
- **total_price**: Total price of the booking.
- **status**: Status of the booking (e.g., pending, confirmed, canceled).

### 3. Discount Table

- **discount_id**: Unique identifier for each discount (Primary Key).
- **code**: Discount code.
- **type**: Type of discount (e.g., percentage, fixed amount).
- **value**: Value of the discount.
- **start_date**: Start date of the discount validity.
- **end_date**: End date of the discount validity.

### 4. Booking_Discount Table (Many-to-Many Relationship)

- **booking_id**: Foreign Key referencing the Booking Table.
- **discount_id**: Foreign Key referencing the Discount Table.
- Represents the relationship between bookings and discounts.

### 5. Report Table

- **report_id**: Unique identifier for each report (Primary Key).
- **booking_id**: Foreign Key referencing the Booking Table.
- **file_path**: Path to the generated report file.
- **generation_date**: Date and time when the report was generated.

## Relationships

- **Yacht - Booking**: One-to-Many relationship. Each booking is associated with one yacht.
- **Booking—Discount**: Many-to-Many relationship. Each booking can have multiple discounts, and each discount can be applied to multiple bookings.
- **Booking - Report**: One-to-One relationship. Each booking is associated with one report.

## Usage

This schema allows the application to manage yacht listings, bookings, discounts, and reports efficiently. Users can book yachts, apply discounts, and generate reports based on their bookings.


# Endpoints

The backend of the Yacht Booking Application exposes the following RESTful API endpoints:

- **GET /api/yachts**: Retrieve a list of available yachts.
- **POST /api/bookings**: Book a yacht by providing user details and yacht ID.
- **POST /api/discounts/apply**: Apply a discount to a booking by providing the discount code and booking ID.
- **GET /api/reports/{bookingId}**: Generate a booking confirmation report for a given booking ID.

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