package com.endava.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(name = Observations.FIND_ALL, query = "select p from Observations p order by p.date desc")})
@Entity
@Table(name = "observations")
public class Observations implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String FIND_ALL = "Observations.findAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200, nullable = true, name = "information")
    private String information;

    @Column(nullable = false, name = "date")
    private Date date;

    @Override
    public String toString() {
        return "Observations{" +
                "id=" + id +
                ", information='" + information + '\'' +
                ", date=" + date +
                ", person=" + person +
                '}';
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date= date;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Observations)) return false;

        Observations that = (Observations) o;

        if (getInformation() != null ? !getInformation().equals(that.getInformation()) : that.getInformation() != null)
            return false;
        if (getDate() != null ? !getDate().equals(that.getDate()) : that.getDate() != null) return false;
        return getPerson() != null ? getPerson().equals(that.getPerson()) : that.getPerson() == null;

    }

    @Override
    public int hashCode() {
        int result = getInformation() != null ? getInformation().hashCode() : 0;
        result = 31 * result + (getDate() != null ? getDate().hashCode() : 0);
        result = 31 * result + (getPerson() != null ? getPerson().hashCode() : 0);
        return result;
    }
}