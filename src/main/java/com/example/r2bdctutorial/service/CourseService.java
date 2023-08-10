package com.example.r2bdctutorial.service;

import com.example.r2bdctutorial.model.Course;
import com.example.r2bdctutorial.repository.CourseRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Flux<Course> findAll() {
        return courseRepository.findAll();
    }

    public Mono<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    public Mono<Course> update(Long id, Course course) {
        return courseRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalCourse -> {
                    if (optionalCourse.isPresent()) {
                        course.setId(id);
                        return courseRepository.save(course);
                    }

                    return Mono.empty();
                });
    }

    public Mono<Course> save(Course course) {
        return courseRepository.save(course);
    }

}
