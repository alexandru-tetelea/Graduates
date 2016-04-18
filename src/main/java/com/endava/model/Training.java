package com.endava.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lordu on 4/17/2016.
 */
@NamedQueries({ @NamedQuery(name = Training.FIND_ALL, query = "select t from Training t"),
		@NamedQuery(name = Training.FIND_TRAINING, query = "select t from Training t where t.description like :description") })
@Entity
@Table(name = "training")
public class Training implements Serializable {
	public static final String FIND_ALL = "Training.findAll";
    public static final String FIND_TRAINING = "Training.findTraining";
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

	public Training() {
	}

	@Column(length = 500, nullable = true, name = "description")
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Discipline.class)
	@JoinTable(name = "training_discipline", joinColumns = {
			@JoinColumn(name = "training_id", nullable = false, updatable = false, table = "training") }, inverseJoinColumns = {
					@JoinColumn(name = "discipline_id", nullable = false, updatable = false, table = "discipline") })
	private List<Discipline> disciplines = new ArrayList<Discipline>();

	public Training(String description, List<Discipline> disciplines) {
		this.description = description;
		this.disciplines = disciplines;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Discipline> getDisciplines() {
		return this.disciplines;
	}

	public void setDisciplines(List<Discipline> disciplines) {
		this.disciplines = disciplines;
	}

	@Override
	public String toString() {
		return "Training{" + "id=" + id + ", description='" + description + '\'' + ", disciplines=" + disciplines + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Training))
			return false;

		Training training = (Training) o;

		if (getDescription() != null ? !getDescription().equals(training.getDescription())
				: training.getDescription() != null)
			return false;
		return getDisciplines() != null ? getDisciplines().equals(training.getDisciplines())
				: training.getDisciplines() == null;

	}

	@Override
	public int hashCode() {
		int result = getDescription() != null ? getDescription().hashCode() : 0;
		result = 31 * result + (getDisciplines() != null ? getDisciplines().hashCode() : 0);
		return result;
	}
}
