# Yacht Booking Application

Welcome to the Yacht Booking Application! This project is a simplified demonstration of a yacht booking system.
With this project, I want to showcase the Java, Spring Boot, SQL, HTML, JavaScript, CSS fundamentals. Also, for the first time, I am using JasperReports to generate booking confirmation reports.

## Features

- **Yacht Listings**: Browse available yachts with details such as name, type, and price per day.
- **Booking Functionality**: Book a yacht by selecting a yacht.
- **Discount Management**: Apply discounts to your bookings, if you know the discount code.
- **Report Generation**: Generate booking confirmation reports.
- **User Interface**: Intuitive interface for easy navigation.

## How to Use

1. **View Yacht Listings**: Visit the application to see the available yachts. Available yachts are displayed on application home page.
2. **Book a Yacht**: Select a yacht and submit the booking form.
3. **Apply Discounts**: If applicable, enter a discount code during the booking process.
4. **Generate Reports**: Upon completing a booking, you can view or download a booking confirmation report.

## Setup and Installation

1. [Clone](#setup-and-installation-1) the repository to your local machine.
2. To start the application, open frontend directory and follow the instructions provided in [documentation](frontend/FrontendDOC.md) file.
3. For the backend setup, follow the instructions provided in the backend directory, [documentation](backend/BackendDOC.md) file .
4. Access the application in your web browser.

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
- **Description**: Users can book a yacht by .
- **Requirements**:
    - Select "start" and "end" date.
    - Send booking data to the backend.
    - Store booking details in the database.

### 3. Discount Management
- **Description**: Apply discounts to bookings.
- **Requirements**:
    - Discount rules (percentage) are defined within discount entity in the database.
    - User must provide discount code to be able to lower the total price.
    - Apply discount to the booking total price.
    - Show discounted price to the user.

### 4. Report Generation - developing
- **Description**: Generate a booking confirmation report using JasperReports.
- **Requirements**:
    - Create a JasperReports template for booking confirmations.
    - Generate a report upon booking completion.
    - User can download or view the report.

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
- **Description**: The user books a yacht by selecting a yacht.
- **Steps**:
    1. User selects a yacht to book.
    2. User select "start" and "end" date.
    3. Application sends booking data to the backend.
    4. Backend stores the booking details.
    5. Application generates a booking confirmation report.
    6. User can view or download the report.

### Use Case 3: Applying a Discount
- **Actor**: User
- **Description**: The user applies a discount to their booking.
- **Steps**:
    1. User selects a yacht to book.
    2. User enters a discount code (if applicable).
    3. Application calculates the discounted price.
    4. User submits the booking.
    5. Application sends booking data to the backend with the discounted price.
    6. Backend stores the booking details with the discount applied.
    7. Application generates a booking confirmation report with the discounted price.
    8. User can view or download the report.


## Setup and Installation
1. **Clone the repository**:
   ```sh
   git clone https://github.com/voki97/yacht-booking-app.git
   cd yacht-booking-app
