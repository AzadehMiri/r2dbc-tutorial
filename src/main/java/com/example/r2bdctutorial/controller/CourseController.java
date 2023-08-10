package com.example.r2bdctutorial.controller;

import com.example.r2bdctutorial.model.Course;
import com.example.r2bdctutorial.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Flux<Course> getAll() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Course> getById(@PathVariable("id") Long id) {
        return courseService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Course> save(@RequestBody Course course) {
        return courseService.save(new Course(course.getName()));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Course> update(@PathVariable("id") Long id,
                                     @RequestBody Course course) {
        return courseService.update(id, course);
    }
}
