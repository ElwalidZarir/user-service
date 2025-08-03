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
CREATE TABLE experience (
    id INT PRIMARY KEY AUTO_INCREMENT,
    company_name VARCHAR(255) NOT NULL,
    job_title VARCHAR(255) NOT NULL,
    start_date VARCHAR(255),
    end_date VARCHAR(255),
    description TEXT,
    profile_id INT NOT NULL,
    CONSTRAINT fk_profile_experience FOREIGN KEY (profile_id) REFERENCES profile(id) ON DELETE CASCADE
);
