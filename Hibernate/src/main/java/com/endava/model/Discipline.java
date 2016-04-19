package com.endava.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lordu on 4/17/2016.
 */
@NamedQueries({
        @NamedQuery(name = Discipline.FIND_ALL, query = "select p from Discipline p"),
        @NamedQuery(name = Discipline.FIND_DISCIPLINE, query = "select p from Discipline p where p.description=:description")
})
@Entity
@Table(name = "discipline")
public class Discipline implements Serializable {
    public static final String FIND_ALL = "Discipline.findAll";
    public static final String FIND_DISCIPLINE = "Discipline.findDiscipline";

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "disciplines", targetEntity = Training.class, cascade = CascadeType.ALL)
    private List<Training> trainings = new ArrayList<Training>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = true, name = "description")
    private String description;

    public Discipline(List<Training> trainings, String description) {
        this.trainings = trainings;
        this.description = description;
    }

    public Discipline() {

    }

    public List<Training> getTrainings() {
        return trainings;
    }

    public void setTrainings(List<Training> trainings) {
        this.trainings = trainings;
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "trainings=" + trainings +
                ", id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Discipline)) return false;

        Discipline that = (Discipline) o;

        if (getTrainings() != null ? !getTrainings().equals(that.getTrainings()) : that.getTrainings() != null)
            return false;
        return getDescription() != null ? getDescription().equals(that.getDescription()) : that.getDescription() == null;

    }

    @Override
    public int hashCode() {
        int result = getTrainings() != null ? getTrainings().hashCode() : 0;
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }
}
