package com.endava.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atetelea on 4/18/2016.
 */
public class DisciplineBuilder {
    private List<Training> trainings = new ArrayList<Training>();
    private String description;

    public DisciplineBuilder setTrainings(List<Training> trainings) {
        this.trainings = trainings;
        return this;
    }

    public DisciplineBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Discipline createDiscipline() {
        return new Discipline(trainings, description);
    }
}
