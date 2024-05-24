# YachtController Class Documentation

## Overview

The `YachtController` class is responsible for handling HTTP requests related to yacht operations such as creating, reading, updating, and deleting yacht records. It serves as a REST controller in the application.

## Annotations

- `@RestController`: Indicates that this class is a REST controller.
- `@RequestMapping("/api/yacht")`: Maps HTTP requests to the `/api/yacht` endpoint.
- `@CrossOrigin`: Allows cross-origin requests.
- `@RequiredArgsConstructor`: Generates a constructor with required arguments (final fields).

## Endpoints

### Create Yacht

- **HTTP Method**: `POST`
- **Endpoint**: `/api/yacht/create`
- **Description**: Creates a new yacht record.
- **Request Body**: `YachtEntityModel` - The yacht entity to be created.
- **Response**: `ResponseEntity<YachtEntityModel>` - The created yacht entity.

### Get All Yachts

- **HTTP Method**: `GET`
- **Endpoint**: `/api/yacht/all`
- **Description**: Retrieves all yacht records.
- **Response**: `ResponseEntity<List<YachtEntityModel>>` - A list of all yacht entities.

### Get Yacht by ID

- **HTTP Method**: `GET`
- **Endpoint**: `/api/yacht/{id}`
- **Description**: Retrieves a specific yacht record by its ID.
- **Path Variable**: `id` - The ID of the yacht record to retrieve.
- **Response**: `ResponseEntity<YachtEntityModel>` - The yacht entity corresponding to the provided ID.

### Update Yacht

- **HTTP Method**: `PUT`
- **Endpoint**: `/api/yacht/update/{id}`
- **Description**: Updates an existing yacht record.
- **Path Variable**: `id` - The ID of the yacht record to update.
- **Request Body**: `YachtEntityModel` - The updated yacht entity.
- **Response**: `ResponseEntity<YachtEntityModel>` - The updated yacht entity.

### Delete Yacht

- **HTTP Method**: `DELETE`
- **Endpoint**: `/api/yacht/delete/{id}`
- **Description**: Deletes a yacht record.
- **Path Variable**: `id` - The ID of the yacht record to delete.
- **Response**: `ResponseEntity<Void>` - Indicates the success of the deletion operation.

# BookingController Class Documentation

## Overview

The `BookingController` class is responsible for handling HTTP requests related to booking operations such as creating, reading, updating, and deleting booking records. It serves as a REST controller in the application.

## Annotations

- `@RestController`: Indicates that this class is a REST controller.
- `@RequestMapping("/api/booking")`: Maps HTTP requests to the `/api/booking` endpoint.
- `@CrossOrigin`: Allows cross-origin requests.
- `@RequiredArgsConstructor`: Generates a constructor with required arguments (final fields).

## Endpoints

### Create Booking

- **HTTP Method**: `POST`
- **Endpoint**: `/api/booking/create`
- **Description**: Creates a new booking record.
- **Request Body**: `BookingEntityModel` - The booking entity to be created.
- **Response**: `ResponseEntity<BookingEntityModel>` - The created booking entity.

### Get All Bookings

- **HTTP Method**: `GET`
- **Endpoint**: `/api/booking/all`
- **Description**: Retrieves all booking records.
- **Response**: `ResponseEntity<List<BookingEntityModel>>` - A list of all booking entities.

### Get Booking by ID

- **HTTP Method**: `GET`
- **Endpoint**: `/api/booking/{id}`
- **Description**: Retrieves a specific booking record by its ID.
- **Path Variable**: `id` - The ID of the booking record to retrieve.
- **Response**: `ResponseEntity<BookingEntityModel>` - The booking entity corresponding to the provided ID.

### Update Booking

- **HTTP Method**: `PUT`
- **Endpoint**: `/api/booking/update/{id}`
- **Description**: Updates an existing booking record.
- **Path Variable**: `id` - The ID of the booking record to update.
- **Request Body**: `BookingEntityModel` - The updated booking entity.
- **Response**: `ResponseEntity<BookingEntityModel>` - The updated booking entity.

### Delete Booking

- **HTTP Method**: `DELETE`
- **Endpoint**: `/api/booking/delete/{id}`
- **Description**: Deletes a booking record.
- **Path Variable**: `id` - The ID of the booking record to delete.
- **Response**: `ResponseEntity<Void>` - Indicates the success of the deletion operation.

# DiscountController Class Documentation

## Overview

The `DiscountController` class is responsible for handling HTTP requests related to discount operations such as creating, reading, updating, and deleting discount records. It serves as a REST controller in the application.

## Annotations

- `@RestController`: Indicates that this class is a REST controller.
- `@RequestMapping("/api/discount")`: Maps HTTP requests to the `/api/discount` endpoint.
- `@CrossOrigin`: Allows cross-origin requests.
- `@RequiredArgsConstructor`: Generates a constructor with required arguments (final fields).

## Endpoints

### Create Discount

- **HTTP Method**: `POST`
- **Endpoint**: `/api/discount/create`
- **Description**: Creates a new discount record.
- **Request Body**: `DiscountEntityModel` - The discount entity to be created.
- **Response**: `ResponseEntity<DiscountEntityModel>` - The created discount entity.

### Get All Discounts

- **HTTP Method**: `GET`
- **Endpoint**: `/api/discount/all`
- **Description**: Retrieves all discount records.
- **Response**: `ResponseEntity<List<DiscountEntityModel>>` - A list of all discount entities.

### Get Discount by ID

- **HTTP Method**: `GET`
- **Endpoint**: `/api/discount/{id}`
- **Description**: Retrieves a specific discount record by its ID.
- **Path Variable**: `id` - The ID of the discount record to retrieve.
- **Response**: `ResponseEntity<DiscountEntityModel>` - The discount entity corresponding to the provided ID.

### Get Discount by code

- **HTTP Method**: `GET`
- **Endpoint**: `/api/discount/code/{code}`
- **Description**: Retrieves a specific discount record by its unique code.
- **Path Variable**: `code` - The code of the discount record to retrieve.
- **Response**: `ResponseEntity<DiscountEntityModel>` - The discount entity corresponding to the provided code variable.

### Update Discount

- **HTTP Method**: `PUT`
- **Endpoint**: `/api/discount/update/{id}`
- **Description**: Updates an existing discount record.
- **Path Variable**: `id` - The ID of the discount record to update.
- **Request Body**: `DiscountEntityModel` - The updated discount entity.
- **Response**: `ResponseEntity<DiscountEntityModel>` - The updated discount entity.

### Delete Discount

- **HTTP Method**: `DELETE`
- **Endpoint**: `/api/discount/delete/{id}`
- **Description**: Deletes a discount record.
- **Path Variable**: `id` - The ID of the discount record to delete.
- **Response**: `ResponseEntity<Void>` - Indicates the success of the deletion operation.

# ReportController Class Documentation

## Overview

The `ReportController` class is responsible for handling HTTP requests related to report operations such as creating, reading, updating, and deleting report records. It serves as a REST controller in the application.

## Annotations

- `@RestController`: Indicates that this class is a REST controller.
- `@RequestMapping("/api/report")`: Maps HTTP requests to the `/api/report` endpoint.
- `@CrossOrigin`: Allows cross-origin requests.
- `@RequiredArgsConstructor`: Generates a constructor with required arguments (final fields).

## Endpoints

### Create Report

- **HTTP Method**: `POST`
- **Endpoint**: `/api/report/create`
- **Description**: Creates a new report record.
- **Request Body**: `ReportEntityModel` - The report entity to be created.
- **Response**: `ResponseEntity<ReportEntityModel>` - The created report entity.

### Get All Reports

- **HTTP Method**: `GET`
- **Endpoint**: `/api/report/all`
- **Description**: Retrieves all report records.
- **Response**: `ResponseEntity<List<ReportEntityModel>>` - A list of all report entities.

### Get Report by ID

- **HTTP Method**: `GET`
- **Endpoint**: `/api/report/{id}`
- **Description**: Retrieves a specific report record by its ID.
- **Path Variable**: `id` - The ID of the report record to retrieve.
- **Response**: `ResponseEntity<ReportEntityModel>` - The report entity corresponding to the provided ID.

### Update Report

- **HTTP Method**: `PUT`
- **Endpoint**: `/api/report/update/{id}`
- **Description**: Updates an existing report record.
- **Path Variable**: `id` - The ID of the report record to update.
- **Request Body**: `ReportEntityModel` - The updated report entity.
- **Response**: `ResponseEntity<ReportEntityModel>` - The updated report entity.

### Delete Report

- **HTTP Method**: `DELETE`
- **Endpoint**: `/api/report/delete/{id}`
- **Description**: Deletes a report record.
- **Path Variable**: `id` - The ID of the report record to delete.
- **Response**: `ResponseEntity<Void>` - Indicates the success of the deletion operation.

NOTE: not everything is documented!
