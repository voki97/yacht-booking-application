# Yacht Booking Application Frontend Documentation

Welcome to the documentation for the frontend of the Yacht Booking Application. This document provides an overview of the frontend structure, files, and features.

## Project Structure

The frontend of the Yacht Booking Application follows a Vue.js directory structure:

src/<br>
├── assets/ - Assets such as images and styles<br>
├── components/ - Reusable Vue components<br>
│ ├── bookings/ - Components related to bookings<br>
│ │ ├── BookingDOC.md - Documentation for booking components<br>
│ │ ├── CreateBooking.js - JavaScript logic for booking component<br>
│ │ └── CreateBooking.vue - Vue component for creating a booking<br>
│ ├── yachts/ - Components related to yachts<br>
│ │ ├── YachtDOC.md - Documentation for yacht components<br>
│ │ ├── YachtsManager.js - JavaScript logic for yachts component<br>
│ │ └── YachtsForBooking.vue - Vue component for listing yachts<br>
├── models/ - Data models<br>
│ ├── Booking.js - Booking data model<br>
│ ├── Yacht.js - Yacht data model<br>
├── App.vue - Main Vue component<br>
└── main.js - Entry point of the application<br>


## Files

- **App.vue**: The root Vue component that serves as the entry point of the application.
- **main.js**: The JavaScript entry point that initializes the Vue application.
- **assets/**: Directory containing static assets such as images and styles.
- **components/**: Directory containing reusable Vue components.
    - **bookings/**: Directory containing components and documentation related to bookings.
        - **BookingDOC.md**: Documentation for booking components.
        - **CreateBooking.js**: JavaScript logic for the booking component.
        - **CreateBooking.vue**: Vue component for creating a booking.
    - **yachts/**: Directory containing components and documentation related to yachts.
        - **YachtDOC.md**: Documentation for yacht components.
        - **YachtsManager.js**: JavaScript logic for the yacht component.
        - **YachtsForBooking.vue**: Vue component for listing yachts.
- **models/**: Directory containing data models.
    - **Booking.js**: Data model for bookings.
    - **Yacht.js**: Data model for yachts.

## Features

The frontend of the Yacht Booking Application provides the following features:

### View Yacht Listings

- Display a list of available yachts with details such as name, type, and price per day.
- Detailed [Yacht documentation](src/components/yachts/YachtDOC.md).

### Book a Yacht

- Allow users to book a yacht by selecting a yacht from the list and providing the necessary booking details.
- Detailed [Booking documentation](src/components/bookings/BookingDOC.md).

### Apply Discounts

- Enable users to apply discounts to their bookings by entering a discount code (if applicable).

### Generate Reports

- Upon completing a booking, users can view or download a booking confirmation report.

## Setup and Installation

To set up the frontend of the Yacht Booking Application locally, follow these steps:

1. Clone the repository to your local machine.
2. Navigate to the frontend directory:
   ```bash
   cd frontend
3. Install dependencies if needed:
    ```bash
   npm install
4. Run the server:
    ```bash
   npm run serve
   
The application should now be running locally on http://localhost:8080.


