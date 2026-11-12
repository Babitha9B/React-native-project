CREATE DATABASE IF NOT EXISTS expense_tracker;
USE expense_tracker;
-- Spring Data JPA creates/updates the transactions table on first run.
-- Equivalent schema:
CREATE TABLE IF NOT EXISTS transactions (
 id BIGINT PRIMARY KEY AUTO_INCREMENT,
 title VARCHAR(100) NOT NULL,
 amount DECIMAL(12,2) NOT NULL,
 type VARCHAR(10) NOT NULL,
 category VARCHAR(50) NOT NULL,
 transaction_date DATE NOT NULL,
 notes VARCHAR(500) NULL
);
