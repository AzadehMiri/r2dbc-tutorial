package com.example.r2bdctutorial.controller;

import com.example.r2bdctutorial.model.Person;
import com.example.r2bdctutorial.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Flux<Person> getAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Person> getById(@PathVariable("id") Long id) {
        return personService.findById(id);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Person> save(@RequestBody Person person) {
        return personService.save(new Person(person.getFirstName(),
                person.getLastName()));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Person> update(@PathVariable("id") Long id,
                                     @RequestBody Person person) {
        return personService.update(id, person);
    }
}
