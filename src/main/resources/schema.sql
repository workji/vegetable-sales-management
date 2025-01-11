DROP TABLE IF EXISTS sales;
DROP TABLE IF EXISTS vegetables;
DROP TABLE IF EXISTS customers;

CREATE TABLE vegetables (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL
);

CREATE TABLE customers (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL
);

CREATE TABLE sales (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    vegetable_id BIGINT NOT NULL,
    customer_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    sale_date DATE NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL
);

CREATE INDEX idx_vegetables_name ON vegetables(name);
CREATE INDEX idx_customers_name ON customers(name);
CREATE INDEX idx_sales_date ON sales(sale_date);
CREATE INDEX idx_sales_vegetable ON sales(vegetable_id);
CREATE INDEX idx_sales_customer ON sales(customer_id);