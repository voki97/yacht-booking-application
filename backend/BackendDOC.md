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

- **Models**: Define entity classes representing domain objects such as yachts, bookings, and discounts. These classes are typically annotated with JPA annotations for database mapping.

- **Repositories**: Provide interfaces for interacting with the database using Spring Data JPA. They extend `JpaRepository`.

- **Services**: Contain business logic and perform operations such as booking a yacht, applying discounts, generating reports. They typically interact with repositories to access and manipulate data.

## Endpoints

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

   2. **Install Homebrew**: If you haven't already installed Homebrew, run the following command in Terminal:
      ```bash
      /bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
   3. **Install MySql**: If you haven't already installed MySql, run the following command in Terminal:
         ```bash
         brew install mysql
   
3. Run the [script](setup_database.sh) to create database, tables and data examples. 
4. **Run MySql**
   ```bash
   mysql -u root -p
If not changed, enter password(default): password