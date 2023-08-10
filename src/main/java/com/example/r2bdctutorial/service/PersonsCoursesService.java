package com.example.r2bdctutorial.service;

import com.example.r2bdctutorial.model.PersonsCourses;
import com.example.r2bdctutorial.repository.PersonsCoursesRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonsCoursesService {
    private final PersonsCoursesRepository personsCoursesRepository;

    public PersonsCoursesService(PersonsCoursesRepository personsCoursesRepository) {
        this.personsCoursesRepository = personsCoursesRepository;
    }

    public Mono<PersonsCourses> save(PersonsCourses personsCourses) {
        return personsCoursesRepository.save(personsCourses);
    }

    public Flux<PersonsCourses> findAllPersons(Long courseId) {
        return personsCoursesRepository.findByCourseId(courseId);
    }

    public Flux<PersonsCourses> findAllCourses(Long personId) {
        return personsCoursesRepository.findByPersonId(personId);
    }
}
