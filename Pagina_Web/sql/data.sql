CREATE TABLE IF NOT EXISTS usuarios (
                                        `id` INT NOT NULL AUTO_INCREMENT,
                                        PRIMARY KEY (`id`),
                                        username VARCHAR(255) NOT NULL UNIQUE,
                                        password VARCHAR(255) NOT NULL
);

-- Insertamos algunos usuarios de prueba
INSERT INTO usuarios (username, password) VALUES
                                              ('pepe', '1234'),
                                              ('admin', 'admin');