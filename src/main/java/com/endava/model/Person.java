package com.endava.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NamedQueries({@NamedQuery(name = Person.FIND_ALL, query = "select p from Person p order by p.lastName"),
        @NamedQuery(name = Person.FIND_GRADUATES, query = "select p from Person p WHERE p.type = :type"),
        @NamedQuery(name = Person.FIND_PERSON, query = "select p from Person p WHERE p.type = :type and p.lastName = :lastName and p.firstName=:firstName and p.email=:email")})

@Entity
@Table(name = "person")
public class Person implements Serializable {

    public static final String FIND_ALL = "Person.findAll";
    public static final String FIND_GRADUATES = "Person.findgraduates";
    public static final String FIND_PERSON = "Person.findPerson";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 64, nullable = false, unique = true, name = "first_name")
    @Size(min = 3, max = 20, message = "First name must be between 3 and 20 characters long.")
    private String firstName;

    @Column(length = 64, nullable = false, unique = true, name = "last_name")
    @Size(min = 3, max = 20, message = "Last name must be between 3 and 20 characters long.")
    private String lastName;

    @Column(length = 64, nullable = false)
    private String email;

    @Column
    @Enumerated(EnumType.STRING)
    private Type type;

    public Person() {
    }

    public Person(String firstName, String lastName, String email, Type type) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (getFirstName() != null ? !getFirstName().equals(person.getFirstName()) : person.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(person.getLastName()) : person.getLastName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(person.getEmail()) : person.getEmail() != null) return false;
        return getType() == person.getType();

    }

    @Override
    public int hashCode() {
        int result = getFirstName() != null ? getFirstName().hashCode() : 0;
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        return result;
    }
}
