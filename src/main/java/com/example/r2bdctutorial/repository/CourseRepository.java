package com.example.r2bdctutorial.repository;

import com.example.r2bdctutorial.model.Course;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface CourseRepository extends R2dbcRepository<Course, Long> {
    Flux<Course> findByName(String name);
}
