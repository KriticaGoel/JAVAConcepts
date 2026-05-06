CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100)
);

CREATE TABLE address (
    address_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT,
    city VARCHAR(50),
    country VARCHAR(50),
    CONSTRAINT fk_user FOREIGN KEY (user_id) REFERENCES users(id)
);