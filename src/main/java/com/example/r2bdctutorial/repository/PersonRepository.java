package com.example.r2bdctutorial.repository;

import com.example.r2bdctutorial.model.Person;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends R2dbcRepository<Person, Long> {
}
