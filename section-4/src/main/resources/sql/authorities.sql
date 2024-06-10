CREATE TABLE authorities (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(45) NOT NULL,
    authority VARCHAR(45) NOT NULL,

    PRIMARY KEY (id)
);

INSERT INTO authorities VALUES (NULL, 'admin', 'tester');