## Yacht Entity

Represents a yacht available for rent.

#### Attributes:

- `yachtId`: Long - Unique identifier for each yacht (Primary Key).
- `name`: String - Name of the yacht.
- `type`: String - Type of the yacht.
- `pricePerDay`: BigDecimal - Price per day for renting the yacht.

---

## Booking Entity

Represents a booking made for renting a yacht.

#### Attributes:

- `bookingId`: Long - Unique identifier for each booking (Primary Key).
- `yacht`: Yacht - Yacht booked for the booking (Many-to-One Relationship with Yacht).
- `bookingDate`: LocalDateTime - Date and time when the booking was made.
- `startDate`: LocalDate - Start date of the booking.
- `endDate`: LocalDate - End date of the booking.
- `totalPrice`: BigDecimal - Total price of the booking.
- `status`: String - Status of the booking (e.g., pending, confirmed, canceled).

---

## Discount Entity

Represents a discount applicable to bookings.

#### Attributes:

- `discountId`: Long - Unique identifier for each discount (Primary Key).
- `code`: String - Discount code.
- `type`: String - Type of discount (e.g., percentage, fixed amount).
- `value`: BigDecimal - Value of the discount.
- `startDate`: LocalDate - Start date of the discount validity.
- `endDate`: LocalDate - End date of the discount validity.

---

## BookingDiscount Entity

Represents the relationship between bookings and discounts.

#### Attributes:

- `booking`: Booking - Booking associated with the discount (Foreign Key referencing the Booking Table).
- `discount`: Discount - Discount applied to the booking (Foreign Key referencing the Discount Table).
- Composite Primary Key (booking, discount).

---

## Report Entity

Represents a report generated for a booking.

#### Attributes:

- `reportId`: Long - Unique identifier for each report (Primary Key).
- `booking`: Booking - Booking associated with the report (Foreign Key referencing the Booking Table).
- `filePath`: String - Path to the generated report file.
- `generationDate`: LocalDateTime - Date and time when the report was generated.
