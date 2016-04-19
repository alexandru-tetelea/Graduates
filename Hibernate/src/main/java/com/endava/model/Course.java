package com.endava.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by lordu on 4/17/2016.
 */
@NamedQueries({@NamedQuery(name = Course.FIND_ALL, query = "select p from Course p")})
@Entity
@Table(name = "course")
public class Course implements Serializable {
    public static final String FIND_ALL = "Course.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = true, name = "description")
    private String description;

    @JoinColumn(name = "training_id")
    @OneToOne (cascade=CascadeType.ALL)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Training training;

    @Column(nullable = false, name = "hours")
    private Long hours;

    @JoinColumn(name = "person_id")
    @OneToOne (cascade=CascadeType.ALL)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Person person;

    public Course(String description, Training training, Long hours, Person person) {
        this.description = description;
        this.training = training;
        this.hours = hours;
        this.person = person;
    }

    public Course() {
    }

    public String getDescription() {
        return description;

    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }

    public Long getHours() {
        return hours;
    }

    public void setHours(Long hours) {
        this.hours = hours;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", hours=" + hours +
                ", person=" + person +
                ", training=" + training +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        if (description != null ? !description.equals(course.description) : course.description != null) return false;
        if (hours != null ? !hours.equals(course.hours) : course.hours != null) return false;
        if (!person.equals(course.person)) return false;
        return training.equals(course.training);

    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (hours != null ? hours.hashCode() : 0);
        result = 31 * result + person.hashCode();
        result = 31 * result + training.hashCode();
        return result;
    }
}
