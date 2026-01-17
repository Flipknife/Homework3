CREATE TABLE customers (
id Int PRIMARY KEY,
name VARCHAR(50) NOT NULL,
region VARCHAR(50) Not NULL
);

INSERT INTO customers (id, name, region) VALUES
(1, 'Иван Иванов', 'Санкт-Петербург'),
(2, 'Пётр Петров', 'Москва'),
(3, 'Анна Смирнова', 'Санкт-Петербург'),
(4, 'Ольга Кузнецова', 'Новосибирск');



CREATE TABLE orders (
order_id INt PRIMARY KEY,
customer_id Int,
product_id INT,
order_date Date,
amount DECIMAL(10,2),
FOREIGN KEY (customer_id) REFERENCES customers(id)
);

INSERT INTO orders (order_id, customer_id, product_id, order_date, amount) VALUES
(1, 1, 1, '2026-01-10', 70000),
(2, 2, 2, '2026-01-11', 30000),
(3, 3, 3, '2026-01-12', 5000),
(4, 4, 1, '2026-01-13', 70000);



CREATE TABLE products1 (
    product_id1 INT PRIMARY KEY,
    product_name VARCHAR(50) NOT NULL,
    price DECIMAL(10,2) NOT NULL
);

INSERT INTO products1 (product_id1, product_name, price) VALUES
(1, 'Ноутбук', 70000),
(2, 'Смартфон', 30000),
(3, 'Наушники', 5000);



SELECT order_id, order_date, customer_id
FROM orders
Where customer_id IN (
    SELECT id
    FROM customers
    Where region = 'Санкт-Петербург'
);

SELECT customers.name, orders.order_id, orders.amount, products1.product_name
FROM customers
INNER JOIN orders ON customers.id = orders.customer_id
INNER JOIN products1 On orders.product_id = products1.product_id1;

SELECT customers.name, orders.order_id, orders.amount, products1.product_name
FROM customers
LEFT JOIN orders On customers.id = orders.customer_id
LEFT JOIN products1 On orders.product_id = products1.product_id1;


CREATE TABLE employees (
id Int PRIMARY Key,
name VARCHAR(50) Not NULL,
department VARCHAR(50) Not NULL,
salary DECIMAL(10,2) NOT NULL
);

INSERT INTO employees (id, name, department, salary) VALUES
(1, 'Иван Иванов', 'IT', 80000),
(2, 'Пётр Петров', 'IT', 70000),
(3, 'Анна Смирнова', 'HR', 50000),
(4, 'Ольга Кузнецова', 'HR', 55000),
(5, 'Сергей Сидоров', 'Sales', 90000),
(6, 'Мария Алексеева', 'Sales', 85000);

SELECT
    department,
    COUNT(*) AS employee_count,
    AVG(salary) AS avg_salary
FROM employees
GROUP BY department
HAVING AVG(salary) > 60000;