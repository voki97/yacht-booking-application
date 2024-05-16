#!/bin/bash

# MySQL database setup script for the Yacht Booking Application

# MySQL connection details
DB_HOST="localhost"
DB_PORT="3306"
DB_USER="root"
DB_PASSWORD="password"

# Path to the SQL script
SQL_SCRIPT="create_tables.sql"

# Database name
DATABASE_NAME="yacht_booking"

# Create the database
mysql -h $DB_HOST -P $DB_PORT -u $DB_USER -p$DB_PASSWORD -e "CREATE DATABASE IF NOT EXISTS $DATABASE_NAME;"

# Use the created database
mysql -h $DB_HOST -P $DB_PORT -u $DB_USER -p$DB_PASSWORD -e "USE $DATABASE_NAME;"

# Execute SQL script
mysql -h "$DB_HOST" -P "$DB_PORT" -u "$DB_USER" -p"$DB_PASSWORD" "$DATABASE_NAME" < "$SQL_SCRIPT"

# Check if the execution was successful
if [ $? -eq 0 ]; then
    echo "SQL script executed successfully."
else
    echo "Error: Failed to execute SQL script."
fi
