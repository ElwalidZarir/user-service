CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255) NOT NULL
);

CREATE TABLE profile (
    id INT AUTO_INCREMENT PRIMARY KEY,
    bio TEXT,
    website VARCHAR(255),
    phone_number VARCHAR(20),
    user_id INT,
    CONSTRAINT fk_profile_user FOREIGN KEY (user_id) REFERENCES user(id) ON DELETE CASCADE
);
