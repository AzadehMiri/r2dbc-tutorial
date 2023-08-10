CREATE TABLE IF NOT EXISTS person (id BIGINT NOT NULL AUTO_INCREMENT, first_name VARCHAR(255), last_name VARCHAR(255), PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS course (id BIGINT NOT NULL AUTO_INCREMENT, name VARCHAR(255), PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS persons_courses (
    person_id BIGINT NOT NULL,
    course_id BIGINT NOT NULL,
    PRIMARY KEY (person_id, course_id),
    FOREIGN KEY (person_id) REFERENCES person(id),
    FOREIGN KEY (course_id) REFERENCES course(id)
);