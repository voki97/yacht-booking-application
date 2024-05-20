# YachtsForBooking Component Documentation

## Overview

The `YachtsForBooking` component displays a list of yachts available for booking. Users can view yacht details and initiate the booking process. The component integrates with the `CreateBooking` component to handle booking confirmation and cancellation.

## Template

### Elements

- **component-container**: The main container for the component.
- **list-container**: A grid container that holds the list of yachts.
- **list-item**: Represents an individual yacht in the list.

### Directives

- `v-for`: Iterates over the `yachts` array to display each yacht.
- `v-if`: Conditionally displays the `CreateBooking` component if a yacht is selected.
- `:key`: Unique key binding for each yacht.
- `@click`: Event handler for initiating the rent process.

## Script

### Data Properties

- **yachts**: An array to store the list of yachts.
- **selectedYacht**: Holds the currently selected yacht for booking.

### Lifecycle Hooks

- **created**: Fetches yachts data when the component is created.

### Methods

- **fetchYachts**: Fetches yachts data from the API and updates the `yachts` array.
- **handleRentButtonClick**: Toggles the selection of a yacht.
- **handleBookingConfirmed**: Resets the selected yacht after booking confirmation.
- **handleBookingCancelled**: Resets the selected yacht after booking cancellation.

## Styles

### CSS Classes

- **component-container**: Centers the component and sets its width.
- **list-container**: Defines the grid layout for the list of yachts.
- **list-item**: Styles each yacht item with padding and background color.

## Dependencies

- **Yacht model**: Represents yacht data.
- **CreateBooking component**: Handles the booking process for the selected yacht.

## API

- **GET /api/yacht/all**: Fetches the list of all available yachts.
