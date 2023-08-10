package com.example.r2bdctutorial.controller;

import com.example.r2bdctutorial.model.Course;
import com.example.r2bdctutorial.model.Person;
import com.example.r2bdctutorial.model.PersonsCourses;
import com.example.r2bdctutorial.service.PersonsCoursesService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/pc")
public class PersonsCoursesController {

    private final PersonsCoursesService personsCoursesService;

    public PersonsCoursesController(PersonsCoursesService personsCoursesService) {
        this.personsCoursesService = personsCoursesService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PersonsCourses> save(@RequestBody PersonsCourses personsCourses) {
        return personsCoursesService.save(new PersonsCourses(personsCourses.getPersonId(),
                personsCourses.getCourseId()));
    }

    @GetMapping("/{courseId}/persons")
    @ResponseStatus(HttpStatus.OK)
    public Flux<PersonsCourses> getByCourseId(@PathVariable("courseId") Long courseId) {
        return personsCoursesService.findAllPersons(courseId);
    }

    @GetMapping("/{personId}/courses")
    @ResponseStatus(HttpStatus.OK)
    public Flux<PersonsCourses> getByPersonId(@PathVariable("personId") Long personId) {
        return personsCoursesService.findAllCourses(personId);
    }
}
