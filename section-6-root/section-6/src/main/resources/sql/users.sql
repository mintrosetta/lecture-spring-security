CREATE TABLE users (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    enabled INT NOT NULL,

    PRIMARY KEY (id)
);

INSERT INTO users VALUES (NULL, 'admin', 'admin', 1);