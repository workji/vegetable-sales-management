-- Sample data for vegetables
DELETE FROM vegetables WHERE id IN (1, 2, 3, 4, 5);
INSERT INTO vegetables (id, name, created_at, updated_at) VALUES
(1, '白菜', NOW(), NOW()),
(2, 'トマト', NOW(), NOW()),
(3, 'きゅうり', NOW(), NOW()),
(4, 'なす', NOW(), NOW()),
(5, 'じゃがいも', NOW(), NOW());

-- Sample data for customers
DELETE FROM customers WHERE id IN (1, 2, 3);
INSERT INTO customers (id, name, address, phone, created_at, updated_at) VALUES
(1, 'スーパーA', '東京都新宿区XX-XX', '03-1234-5678', NOW(), NOW()),
(2, 'スーパーB', '東京都渋谷区YY-YY', '03-2345-6789', NOW(), NOW()),
(3, 'スーパーC', '東京都品川区ZZ-ZZ', '03-3456-7890', NOW(), NOW());

-- Sample data for sales
DELETE FROM sales WHERE vegetable_id IN (1, 2, 3, 4, 5) AND customer_id IN (1, 2, 3);
INSERT INTO sales (vegetable_id, customer_id, quantity, price, sale_date, created_at, updated_at) VALUES
(1, 1, 100, 150.00, CURRENT_DATE(), NOW(), NOW()),
(2, 1, 50, 300.00, CURRENT_DATE(), NOW(), NOW()),
(3, 2, 80, 100.00, CURRENT_DATE(), NOW(), NOW()),
(4, 3, 120, 200.00, CURRENT_DATE(), NOW(), NOW()),
(5, 2, 60, 250.00, CURRENT_DATE(), NOW(), NOW());