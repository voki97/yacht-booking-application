-- Create Yacht Table
CREATE TABLE yacht (
                       yacht_id INT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       type VARCHAR(100),
                       price_per_day DECIMAL(10, 2) NOT NULL
);

-- Create Booking Table
CREATE TABLE booking (
                         booking_id INT AUTO_INCREMENT PRIMARY KEY,
                         yacht_id INT NOT NULL,
                         booking_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         start_date DATE NOT NULL,
                         end_date DATE NOT NULL,
                         total_price DECIMAL(10, 2) NOT NULL,
                         status VARCHAR(20) NOT NULL,
                         CONSTRAINT fk_booking_yacht_id
                         FOREIGN KEY (yacht_id) REFERENCES yacht(yacht_id)
);

-- Create Discount Table
CREATE TABLE discount (
                          discount_id INT AUTO_INCREMENT PRIMARY KEY,
                          code VARCHAR(20) NOT NULL,
                          type VARCHAR(20) NOT NULL,
                          value DECIMAL(5, 2) NOT NULL,
                          start_date DATE,
                          end_date DATE,
                          CONSTRAINT uk_code UNIQUE (code)
);

-- Create Booking_Discount Join Table (Many-to-Many Relationship)
CREATE TABLE booking_discount (
                                  booking_id INT,
                                  discount_id INT,
                                  PRIMARY KEY (booking_id, discount_id),
                                  CONSTRAINT fk_discount_booking_id
                                  FOREIGN KEY (booking_id) REFERENCES booking(booking_id),
                                  CONSTRAINT fk_booking_discount_id
                                  FOREIGN KEY (discount_id) REFERENCES discount(discount_id)
);

-- Create Report Table
CREATE TABLE report (
                        report_id INT AUTO_INCREMENT PRIMARY KEY,
                        booking_id INT NOT NULL,
                        generation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        CONSTRAINT fk_report_booking_id
                        FOREIGN KEY (booking_id) REFERENCES booking(booking_id)
);
