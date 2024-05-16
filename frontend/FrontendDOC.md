# Yacht Booking Application Frontend Documentation

Welcome to the documentation for the frontend of the Yacht Booking Application. This document provides an overview of the frontend structure, files, and features.

## Project Structure

The frontend of the Yacht Booking Application follows a simple directory structure:

frontend/<br>
│<br>
├── index.html # Entry point of the application<br>
├── styles.css # CSS styles for styling the application<br>
├── script.js # JavaScript code for adding interactivity<br>
└── ...
## Files

- **index.html**: This file serves as the entry point of the application. It contains the HTML markup for the user interface, including elements such as headings, forms, buttons, and placeholders for dynamic content.

- **styles.css**: This file contains the CSS styles for styling the application. It defines the appearance, layout, and visual elements of the user interface, including colors, fonts, margins, paddings, and responsiveness for different screen sizes.

- **script.js**: This file contains the JavaScript code for adding interactivity to the application. It handles user interactions, such as button clicks, form submissions, and dynamic content updates. It may also make AJAX requests to fetch data from the backend and update the UI accordingly.

## Features

The frontend of the Yacht Booking Application provides the following features:

1. **View Yacht Listings**: Display a list of available yachts with details such as name, type, and price per day.

2. **Book a Yacht**: Allow users to book a yacht by providing their name and selecting a yacht from the list.

3. **Apply Discounts**: Enable users to apply discounts to their bookings by entering a discount code (if applicable).

4. **Generate Reports**: Upon completing a booking, users can view or download a booking confirmation report.

## Setup and Installation

To set up the frontend of the Yacht Booking Application locally, follow these steps:

1. [Clone](/README.md) the repository to your local machine.

2. Navigate to the `frontend` directory:
   ```bash
   cd frontend
3. Install http-server globally (if not installed):
	```bash
	npm install -g http-server
4. Start server:
	```bash
	http-server
