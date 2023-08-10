package com.example.r2bdctutorial.repository;

import com.example.r2bdctutorial.model.PersonsCourses;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface PersonsCoursesRepository extends R2dbcRepository<PersonsCourses, Long> {

    Flux<PersonsCourses> findByCourseId(Long courseId);

    Flux<PersonsCourses> findByPersonId(Long personId);
}
