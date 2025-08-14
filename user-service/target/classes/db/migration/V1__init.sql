CREATE TABLE roles (
    id SERIAL PRIMARY KEY,
    role_name VARCHAR(20) UNIQUE NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    role_id BIGINT REFERENCES roles(id),
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(100),
    date_of_birth DATE,
    address VARCHAR(255),
    status VARCHAR(50),
    is_studying BOOLEAN,
    elo_score INTEGER,
    elo_rank VARCHAR(50),
    created_at TIMESTAMP
);

CREATE TABLE elo_history (
    id SERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(id),
    action VARCHAR(50),
    points INT,
    description VARCHAR(255),
    created_at TIMESTAMP
);
