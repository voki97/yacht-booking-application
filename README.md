# Yacht Booking Application

Welcome to the Yacht Booking Application! This project is a simplified demonstration of a yacht booking system designed to showcase core features and best practices.

## Features

- **Yacht Listings**: Browse available yachts with details such as name, type, and price per day.
- **Booking Functionality**: Book a yacht by providing your name and selecting a yacht.
- **Discount Management**: Apply discounts to your bookings.
- **Report Generation**: Generate booking confirmation reports.
- **User Interface**: Clean and intuitive interface for easy navigation.

## How to Use

1. **View Yacht Listings**: Visit the application to see the available yachts.
2. **Book a Yacht**: Select a yacht, provide your name, and submit the booking form.
3. **Apply Discounts**: If applicable, enter a discount code during the booking process.
4. **Generate Reports**: Upon completing a booking, you can view or download a booking confirmation report.

## Setup and Installation

1. [Clone](#setup-and-installation-1) the repository to your local machine.
2. To start the application by running an HTTP server, open frontend directory and follow the instructions provided in [documentation](frontend/FrontendDOC.md) file.
3. For the backend setup, follow the instructions provided in the backend directory, [documentation](backend/BackendDOC.md) file .
4. Access the application in your web browser and start exploring!

## Features
1. **Yacht Listings**: Display a list of available yachts.
2. **Booking Functionality**: Allow users to book a yacht.
3. **Discount Management**: Apply discounts to bookings.
4. **Report Generation**: Generate a booking confirmation report using JasperReports.
5. **User Interface**: Provide a clean and responsive UI.

## Detailed Requirements

### 1. Yacht Listings
- **Description**: Users can view a list of available yachts.
- **Requirements**:
    - Retrieve yacht data from the backend.
    - Display yacht details including name, type, and price per day.

### 2. Booking Functionality
- **Description**: Users can book a yacht by providing their name and selecting a yacht.
- **Requirements**:
    - Form to capture username and selected yacht.
    - Send booking data to the backend.
    - Store booking details in the database.

### 3. Discount Management
- **Description**: Apply discounts to bookings.
- **Requirements**:
    - Define discount rules (e.g., percentage off).
    - Apply discount to the booking total price.
    - Show discounted price to the user.

### 4. Report Generation
- **Description**: Generate a booking confirmation report using JasperReports.
- **Requirements**:
    - Create a JasperReports template for booking confirmations.
    - Generate a report upon booking completion.
    - Provide download or view option for the report.

### 5. User Interface
- **Description**: A clean and responsive UI that is easy to use.
- **Requirements**:
    - HTML and CSS for layout and styling.
    - JavaScript for interactivity.
    - Responsive design for mobile and desktop views.

## Non-Functional Requirements
- **Performance**: The application should respond quickly to user actions.
- **Usability**: The UI should be intuitive and user-friendly.
- **Reliability**: The application should handle errors gracefully.
- **Maintainability**: The codebase should be clean and well-documented.

## Technical Requirements
- **Backend**: Java with Spring Boot.
- **Frontend**: HTML, CSS, JavaScript.
- **Reports**: JasperReports.
- **Database**: MySQL.

## Dependencies

### Backend Dependencies:
- **Spring Web**: Provides the necessary components for creating web applications with Spring MVC.
- **Spring Data JPA**: Simplifies the implementation of the data access layer by providing easy-to-use abstractions over JPA.
- **MySQL Driver**: Connector for the MySQL database.
- **Spring Boot DevTools**: Provides additional development-time features like automatic restarts.
- **Lombok**: A library that helps reduce boilerplate code in Java.

### Frontend Dependencies (Optional, depending on your frontend technology):
- **Thymeleaf**: A server-side Java template engine for web and standalone environments.
- **Bootstrap**: A popular CSS framework for building responsive and mobile-first websites.


## Use Cases

### Use Case 1: Viewing Yachts
- **Actor**: User
- **Description**: The user visits the application and sees a list of available yachts.
- **Steps**:
    1. User opens the application.
    2. Application retrieves yacht data from the backend.
    3. Application displays the list of yachts.

### Use Case 2: Booking a Yacht
- **Actor**: User
- **Description**: The user books a yacht by filling out a form with their name and selecting a yacht.
- **Steps**:
    1. User selects a yacht to book.
    2. User fills out the booking form with their name.
    3. User submits the form.
    4. Application sends booking data to the backend.
    5. Backend stores the booking details.
    6. Application generates a booking confirmation report.
    7. User can view or download the report.

### Use Case 3: Applying a Discount
- **Actor**: User
- **Description**: The user applies a discount to their booking.
- **Steps**:
    1. User selects a yacht to book.
    2. User fills out the booking form with their name.
    3. User enters a discount code (if applicable).
    4. Application calculates the discounted price.
    5. User submits the form.
    6. Application sends booking data to the backend with the discounted price.
    7. Backend stores the booking details with the discount applied.
    8. Application generates a booking confirmation report with the discounted price.
    9. User can view or download the report.


## Setup and Installation
1. **Clone the repository**:
   ```sh
   git clone https://github.com/voki97/yacht-booking-app.git
   cd yacht-booking-app