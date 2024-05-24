# YachtService Class

The `YachtService` class provides methods for CRUD (Create, Read, Update, Delete) operations related to yacht entities. It serves as a service layer component in the application.

## Dependencies

- **YachtRepository**: A dependency injected into the `YachtService` class for accessing yacht data from the database.

## Constructors

- **YachtService(YachtRepository yachtRepo)**: Constructs a new `YachtService` instance with the specified `YachtRepository` dependency.

## Methods

### `createYacht(YachtEntityModel yachtEntityModel)`

Create a new yacht entity in the database.

- **Parameters**:
    - `yachtEntityModel`: The yacht entity to be created.

- **Returns**:
    - `YachtEntityModel`: The created yacht entity.

### `getAllYachts()`

Retrieve a list of all yacht entities from the database.

- **Returns**:
    - `List<YachtEntityModel>`: A list of all yacht entities.

### `getYachtById(int id)`

Retrieves a specific yacht entity from the database by its ID.

- **Parameters**:
    - `id`: The ID of the yacht entity to retrieve.

- **Returns**:
    - `YachtEntityModel`: The yacht entity with the specified ID.

- **Throws**:
    - `IllegalArgumentException`: If no yacht entity is found with the specified ID.

### `updateYacht(int id, YachtEntityModel yachtUpdateData)`

Updates an existing yacht entity in the database.

- **Parameters**:
    - `id`: The ID of the yacht entity to update.
    - `yachtUpdateData`: The updated data for the yacht entity.

- **Returns**:
    - `YachtEntityModel`: The updated yacht entity.

- **Throws**:
    - `IllegalArgumentException`: If no yacht entity is found with the specified ID.

### `deleteYacht(int id)`

Deletes a yacht entity from the database by its ID.

- **Parameters**:
    - `id`: The ID of the yacht entity to delete.
# BookingService Class

The `BookingService` class provides methods for CRUD (Create, Read, Update, Delete) operations related to booking entities. It serves as a service layer component in the application.

## Dependencies

- **BookingRepository**: A dependency injected into the `BookingService` class for accessing booking data from the database.

## Constructors

- **BookingService(BookingRepository bookingRepository)**: Constructs a new `BookingService` instance with the specified `BookingRepository` dependency.

## Methods

### `createBooking(BookingEntityModel booking)`

Create a new booking entity in the database.

- **Parameters**:
  - `booking`: The booking entity to be created.
  - `discountIds`: set of discount IDs if available, to insert into booking_discount table.

- **Returns**:
  - `BookingEntityModel`: The created booking entity.

### `getAllBookings()`

Retrieve a list of all booking entities from the database.

- **Returns**:
  - `List<BookingEntityModel>`: A list of all booking entities. Returns an empty list if no bookings are found.

### `getBookingById(int bookingId)`

Retrieves a specific booking entity from the database by its ID.

- **Parameters**:
  - `bookingId`: The ID of the booking entity to retrieve.

- **Returns**:
  - `BookingEntityModel`: The booking entity with the specified ID.

- **Throws**:
  - `IllegalStateException`: If no booking entity is found with the specified ID.

### `updateBooking(int bookingId, BookingEntityModel bookingUpdateData)`

Updates an existing booking entity in the database.

- **Parameters**:
  - `bookingId`: The ID of the booking entity to update.
  - `bookingUpdateData`: The updated data for the booking entity.

- **Returns**:
  - `BookingEntityModel`: The updated booking entity.

- **Throws**:
  - `IllegalStateException`: If no booking entity is found with the specified ID.

### `deleteBooking(int bookingId)`

Deletes a booking entity from the database by its ID.

- **Parameters**:
  - `bookingId`: The ID of the booking entity to delete.
# DiscountService Class

The `DiscountService` class provides methods for CRUD (Create, Read, Update, Delete) operations related to discount entities. It serves as a service layer component in the application.

## Dependencies

- **DiscountRepository**: A dependency injected into the `DiscountService` class for accessing discount data from the database.

## Constructors

- **DiscountService(DiscountRepository discountRepository)**: Constructs a new `DiscountService` instance with the specified `DiscountRepository` dependency.

## Methods

### `createDiscount(DiscountEntityModel discountEntityModel)`

Create a new discount entity in the database.

- **Parameters**:
  - `discountEntityModel`: The discount entity to be created.

- **Returns**:
  - `DiscountEntityModel`: The created discount entity.

### `getAllDiscounts()`

Retrieve a list of all discount entities from the database.

- **Returns**:
  - `List<DiscountEntityModel>`: A list of all discount entities. Returns an empty list if no discounts are found.

### `getDiscountById(int discountId)`

Retrieve a specific discount entity from the database by its ID.

- **Parameters**:
  - `discountId`: The ID of the discount entity to retrieve.

- **Returns**:
  - `DiscountEntityModel`: The discount entity with the specified ID.

- **Throws**:
  - `IllegalArgumentException`: If no discount entity is found with the specified ID.

### `getDiscountByCode(String code)`

Retrieve a specific discount entity from the database by unique code.

- **Parameters**:
  - `discountId`: The code of the discount entity to retrieve.

- **Returns**:
  - `DiscountEntityModel`: The discount entity with the specified code.

- **Throws**:
  - `IllegalArgumentException`: If no discount entity is found with the specified code.

### `updateDiscount(int discountId, DiscountEntityModel discountUpdateData)`

Updates an existing discount entity in the database.

- **Parameters**:
  - `discountId`: The ID of the discount entity to update.
  - `discountUpdateData`: The updated data for the discount entity.

- **Returns**:
  - `DiscountEntityModel`: The updated discount entity.

- **Throws**:
  - `IllegalArgumentException`: If no discount entity is found with the specified ID.

### `deleteDiscountById(int discountId)`

Deletes a discount entity from the database by its ID.

- **Parameters**:
  - `discountId`: The ID of the discount entity to delete.

# ReportService Class

The `ReportService` class provides methods for CRUD (Create, Read, Update, Delete) operations related to report entities. It serves as a service layer component in the application.

## Dependencies

- **ReportRepository**: A dependency injected into the `ReportService` class for accessing report data from the database.

## Constructors

- **ReportService(ReportRepository reportRepository)**: Constructs a new `ReportService` instance with the specified `ReportRepository` dependency.

## Methods

### `createReport(ReportEntityModel reportEntityModel)`

Create a new report entity in the database.

- **Parameters**:
  - `reportEntityModel`: The report entity to be created.

- **Returns**:
  - `ReportEntityModel`: The created report entity.

### `getAllReports()`

Retrieve a list of all report entities from the database.

- **Returns**:
  - `List<ReportEntityModel>`: A list of all report entities. Returns an empty list if no reports are found.

### `getReportById(int reportId)`

Retrieves a specific report entity from the database by its ID.

- **Parameters**:
  - `reportId`: The ID of the report entity to retrieve.

- **Returns**:
  - `ReportEntityModel`: The report entity with the specified ID.

- **Throws**:
  - `IllegalArgumentException`: If no report entity is found with the specified ID.

### `updateReport(int reportId, ReportEntityModel reportUpdateData)`

Updates an existing report entity in the database.

- **Parameters**:
  - `reportId`: The ID of the report entity to update.
  - `reportUpdateData`: The updated data for the report entity.

- **Returns**:
  - `ReportEntityModel`: The updated report entity.

- **Throws**:
  - `IllegalArgumentException`: If no report entity is found with the specified ID.

### `deleteReportById(int reportId)`

Deletes a report entity from the database by its ID.

- **Parameters**:
  - `reportId`: The ID of the report entity to delete.

NOTE: documentation is not complete!