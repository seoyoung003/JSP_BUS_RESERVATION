CREATE DATABASE bus_reservation;
USE bus_reservation;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    phone VARCHAR(15),
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100),
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO users (name, phone, username, email, password) 
VALUES ('배추', '010-9876-5432', 'baechu', 'baechu@example.com', '1234');
VALUES ('홍길동', '010-1234-5678', 'honggildong', 'hong@example.com', 'hashed_password');

COMMIT;
