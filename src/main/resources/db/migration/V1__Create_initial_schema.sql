-- Criando a tabela Course
CREATE TABLE courses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    category_courses VARCHAR(255) NOT NULL
);

-- Criando a tabela User
CREATE TABLE users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Criando a tabela Topic
CREATE TABLE topics (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    message TEXT NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    status VARCHAR(255) NOT NULL,
    author_id BIGINT,
    course_id BIGINT,
    FOREIGN KEY (author_id) REFERENCES users(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);

-- Criando a tabela Reply
CREATE TABLE replies (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    message TEXT NOT NULL,
    creation_date TIMESTAMP NOT NULL,
    author_id BIGINT,
    topic_id BIGINT,
    solution TEXT,
    FOREIGN KEY (author_id) REFERENCES users(id),
    FOREIGN KEY (topic_id) REFERENCES topics(id)
);
