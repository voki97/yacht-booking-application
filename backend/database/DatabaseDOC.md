# Yacht Booking Application Database Documentation

## Overview

This document provides an overview of the database schema for the Yacht Booking Application. The schema consists of several tables to manage yachts, bookings, discounts, and reports.

## Tables

### 1. Yacht Table

- **yacht_id**: Unique identifier for each yacht (Primary Key).
- **name**: Name of the yacht.
- **type**: Type of the yacht.
- **price_per_day**: Price per day for renting the yacht.

### 2. Booking Table

- **booking_id**: Unique identifier for each booking (Primary Key).
- **yacht_id**: Foreign Key referencing the Yacht Table.
- **booking_date**: Date and time when the booking was made.
- **start_date**: Start date of the booking.
- **end_date**: End date of the booking.
- **total_price**: Total price of the booking.
- **status**: Status of the booking (e.g., pending, confirmed, canceled).

### 3. Discount Table

- **discount_id**: Unique identifier for each discount (Primary Key).
- **code**: Discount code (Unique Key).
- **type**: Type of discount (e.g., percentage, fixed amount).
- **value**: Value of the discount.
- **start_date**: Start date of the discount validity.
- **end_date**: End date of the discount validity.

### 4. Booking_Discount Table (Many-to-Many Relationship)

- **booking_id**: Foreign Key referencing the Booking Table.
- **discount_id**: Foreign Key referencing the Discount Table.
- Represents the relationship between bookings and discounts.

### 5. Report Table

- **report_id**: Unique identifier for each report (Primary Key).
- **booking_id**: Foreign Key referencing the Booking Table.
- **file_path**: Path to the generated report file.
- **generation_date**: Date and time when the report was generated.

## Relationships

- **Yacht - Booking**: One-to-Many relationship. Each booking is associated with one yacht.
- **Booking—Discount**: Many-to-Many relationship. Each booking can have multiple discounts, and each discount can be applied to multiple bookings.
- **Booking - Report**: One-to-One relationship. Each booking is associated with one report.

## Usage

This schema allows the application to manage yacht listings, bookings, discounts, and reports efficiently. Users can book yachts, apply discounts, and generate reports based on their bookings.
