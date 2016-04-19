package com.endava.model;

/**
 * Created by atetelea on 4/18/2016.
 */
public class CourseBuilder {
    private String description;
    private Training training;
    private Long hours;
    private Person person;

    public CourseBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public CourseBuilder setTraining(Training training) {
        this.training = training;
        return this;
    }

    public CourseBuilder setHours(Long hours) {
        this.hours = hours;
        return this;
    }

    @Override
    public String toString() {
        return "CourseBuilder{" +
                "description='" + description + '\'' +
                ", training=" + training +
                ", hours=" + hours +
                ", person=" + person +
                '}';
    }

    public CourseBuilder setPerson(Person person) {
        this.person = person;
        return this;
    }

    public Course createCourse() {
        return new Course(description, training, hours, person);
    }

}
