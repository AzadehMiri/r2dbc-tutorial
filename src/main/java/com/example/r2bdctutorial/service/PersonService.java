package com.example.r2bdctutorial.service;

import com.example.r2bdctutorial.model.Person;
import com.example.r2bdctutorial.repository.PersonRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Flux<Person> findAll() {
        return personRepository.findAll();
    }

    public Mono<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public Mono<Person> update(Long id, Person person) {
        return personRepository.findById(id).map(Optional::of).defaultIfEmpty(Optional.empty())
                .flatMap(optionalPerson -> {
                    if (optionalPerson.isPresent()) {
                        person.setId(id);
                        return personRepository.save(person);
                    }

                    return Mono.empty();
                });
    }

    public Mono<Person> save(Person person) {
        return personRepository.save(person);
    }

}
