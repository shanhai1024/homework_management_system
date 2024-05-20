


CREATE TABLE categories (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            name VARCHAR(255) NOT NULL
);


CREATE TABLE yearly_data (
                             id INT PRIMARY KEY AUTO_INCREMENT,
                             category_id INT NOT NULL,
                             year INT NOT NULL,
                             value DECIMAL(10, 2) NOT NULL,
                             FOREIGN KEY (category_id) REFERENCES categories(id)
);

INSERT INTO categories (name) VALUES ('学生'), ('教师'), ('物业'), ('经营者'), ('其他');

INSERT INTO yearly_data (category_id, year, value) VALUES
                                                       (1, 2012, 56.5),
                                                       (1, 2013, 82.1),
                                                       (1, 2014, 88.7),
                                                       (1, 2015, 70.1),
                                                       (1, 2016, 53.4),
                                                       (1, 2017, 300.1),

                                                       (2, 2012, 51.1),
                                                       (2, 2013, 51.4),
                                                       (2, 2014, 55.1),
                                                       (2, 2015, 53.3),
                                                       (2, 2016, 73.8),
                                                       (2, 2017, 68.7),

                                                       (3, 2012, 40.1),
                                                       (3, 2013, 62.2),
                                                       (3, 2014, 69.5),
                                                       (3, 2015, 36.4),
                                                       (3, 2016, 45.2),
                                                       (3, 2017, 32.5),

                                                       (4, 2012, 25.2),
                                                       (4, 2013, 37.1),
                                                       (4, 2014, 41.2),
                                                       (4, 2015, 18.0),
                                                       (4, 2016, 33.9),
                                                       (4, 2017, 49.1),

                                                       (5, 2012, 25.2),
                                                       (5, 2013, 37.1),
                                                       (5, 2014, 41.2),
                                                       (5, 2015, 18.0),
                                                       (5, 2016, 33.9),
                                                       (5, 2017, 49.1);
