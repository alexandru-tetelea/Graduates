package com.endava.model;

public class PersonBuilder {
    private String firstName;
    private String lastName;
    private String email;
    private Type type;

    public PersonBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "PersonBuilder{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                '}';
    }

    public PersonBuilder setType(Type type) {
        this.type = type;
        return this;
    }

    public Person createPerson() {
        return new Person(firstName, lastName, email, type);
    }
}