package com.example.r2bdctutorial.repository;

import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class PersonsCoursesRepositoryImpl {
    private final PersonRepository personRepository;
    private final DatabaseClient client;

    public PersonsCoursesRepositoryImpl(PersonRepository personRepository, DatabaseClient client) {
        this.personRepository = personRepository;
        this.client = client;
    }

    @Transactional
    public Mono<List<Long>> savePersonCourses1(Long personId, List<Long> courseIdList) {
        String query = "INSERT INTO persons_courses(person_id, course_id) VALUES (:person_id, :course_id)";

        return Flux.fromIterable(courseIdList)
                .flatMap(course -> client.sql(query)
                        .bind("person_id", personId)
                        .bind("course_id", course)
                        .fetch().rowsUpdated())
                .collectList();
    }
}
