# CreateBooking Component Documentation

## Overview

The `CreateBooking` component allows users to create a booking for a selected yacht. It provides date pickers for selecting the start and end dates of the booking, calculates the total price, and handles booking confirmation and cancellation.

## Template

### Elements

- **booking-container**: The main container for the booking component.
- **booking-content**: The inner container holding the booking details.
- **date-picker-container**: Contains the date pickers for start and end dates.
- **start-date-picker**: Contains the label and input for the start date.
- **end-date-picker**: Contains the label and input for the end date.
- **total-price-container**: Displays the total price of the booking.

### Directives

- `v-model`: Two-way data binding for the date inputs.
- `@change`: Event handler for calculating the total price when dates change.
- `@click`: Event handlers for confirming or canceling the booking.

## Script

### Props

- **yacht**: An object representing the yacht to be booked, required for the component to function.

### Data Properties

- **startDate**: The selected start date for the booking.
- **endDate**: The selected end date for the booking.
- **totalPrice**: The calculated total price for the booking.

### Methods

- **calculateTotalPrice**: Calculates the total price based on the selected start and end dates and the yacht's price per day.
- **confirmBooking**: Sends a booking request to the server and emits a confirmation event if successful.
- **cancelBooking**: Emits a cancellation event to close the booking form.

### Computed Properties

- **minStartDate**: The minimum selectable start date, set to the current date.
- **maxStartDate**: The maximum selectable start date, set to one day before the selected end date.
- **minEndDate**: The minimum selectable end date, set to one day after the selected start date.

## Styles

### CSS Classes

- **booking-container**: Centers the booking component.
- **booking-content**: Sets the width, padding, and background color for the booking content.

## Dependencies

- **Yacht model**: Represents yacht data.

## API

- **POST /api/booking/create**: Endpoint for creating a new booking.
