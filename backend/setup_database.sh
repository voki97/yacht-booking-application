#!/bin/bash

# MySQL database setup script for the Yacht Booking Application

# MySQL connection details
DB_HOST="localhost"
DB_PORT="3306"
DB_USER="root"
DB_PASSWORD="password"

# Database and table names
DATABASE_NAME="yacht_booking"
TABLE_NAME="yachts"

# Create the database
mysql -h $DB_HOST -P $DB_PORT -u $DB_USER -p$DB_PASSWORD -e "CREATE DATABASE IF NOT EXISTS $DATABASE_NAME;"

# Use the created database
mysql -h $DB_HOST -P $DB_PORT -u $DB_USER -p$DB_PASSWORD -e "USE $DATABASE_NAME;"

# Create the table
mysql -h $DB_HOST -P $DB_PORT -u $DB_USER -p$DB_PASSWORD -D $DATABASE_NAME -e "CREATE TABLE IF NOT EXISTS $TABLE_NAME (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);"

# Insert sample data (optional)
mysql -h $DB_HOST -P $DB_PORT -u $DB_USER -p$DB_PASSWORD -D $DATABASE_NAME -e "INSERT INTO $TABLE_NAME (name, type, price) VALUES
('Yacht A', 'Bareboat', 1000.00),
('Yacht B', 'Skippered', 1500.00),
('Yacht C', 'Fully Crewed', 2000.00);"

echo "MySQL database setup completed."
