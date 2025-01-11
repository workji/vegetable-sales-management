INSERT INTO vegetables (name, created_at, updated_at) VALUES
('Cabbage', NOW(), NOW()),
('Tomato', NOW(), NOW()),
('Cucumber', NOW(), NOW()),
('Eggplant', NOW(), NOW()),
('Potato', NOW(), NOW());

INSERT INTO customers (name, address, phone, created_at, updated_at) VALUES
('Supermarket A', 'Shinjuku-ku, Tokyo', '03-1234-5678', NOW(), NOW()),
('Supermarket B', 'Shibuya-ku, Tokyo', '03-2345-6789', NOW(), NOW()),
('Supermarket C', 'Shinagawa-ku, Tokyo', '03-3456-7890', NOW(), NOW());

INSERT INTO sales (vegetable_id, customer_id, quantity, price, sale_date, created_at, updated_at) VALUES
(1, 1, 100, 150.00, CURRENT_DATE(), NOW(), NOW()),
(2, 1, 50, 300.00, CURRENT_DATE(), NOW(), NOW()),
(3, 2, 80, 100.00, CURRENT_DATE(), NOW(), NOW()),
(4, 3, 120, 200.00, CURRENT_DATE(), NOW(), NOW()),
(5, 2, 60, 250.00, CURRENT_DATE(), NOW(), NOW());