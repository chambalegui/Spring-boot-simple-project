DROP TABLE IF EXISTS course;

CREATE TABLE course (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL
);

INSERT INTO course (name, description) VALUES ('Java', 'Ejemplo básico con spring boot');