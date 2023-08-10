package com.example.r2bdctutorial.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table
public class PersonsCourses implements Serializable {
    @Id
    private Long id;

    private Long personId;

    private Long courseId;

    public PersonsCourses() {
    }

    public PersonsCourses(Long personId, Long courseId) {
        this.personId = personId;
        this.courseId = courseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }
}
