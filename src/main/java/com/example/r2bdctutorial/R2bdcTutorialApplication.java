package com.example.r2bdctutorial;

import com.example.r2bdctutorial.repository.PersonsCoursesRepositoryImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.web.reactive.config.EnableWebFlux;

import java.util.List;

@EnableWebFlux
@SpringBootApplication
public class R2bdcTutorialApplication implements CommandLineRunner {
    private final PersonsCoursesRepositoryImpl personsCoursesRepository;
    private final DatabaseClient client;

    public R2bdcTutorialApplication(PersonsCoursesRepositoryImpl personsCoursesRepository, DatabaseClient client) {
        this.personsCoursesRepository = personsCoursesRepository;
        this.client = client;
    }

    public static void main(String[] args) {
        SpringApplication.run(R2bdcTutorialApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Long personId = 1L;
        List<Long> courseIdList = List.of(1L);
//        Mono<List<Long>> listMono = savePersonCourses1(personId, courseIdList);
        String query = "INSERT INTO persons_courses(person_id, course_id) VALUES (:person_id, :course_id)";
        client.sql(query)
                .bind("person_id", personId)
                .bind("course_id", courseIdList.get(0));
    }
}
