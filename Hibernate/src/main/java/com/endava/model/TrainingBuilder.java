package com.endava.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by atetelea on 4/18/2016.
 */
public class TrainingBuilder {
    private Long id;
    private String description;
    private List<Discipline> disciplines = new ArrayList<Discipline>();

    public TrainingBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public TrainingBuilder setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
        return this;
    }

    public Training createTraining() {
        return new Training(description, disciplines);
    }
}
