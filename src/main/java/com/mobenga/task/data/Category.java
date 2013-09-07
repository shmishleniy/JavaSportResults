package com.mobenga.task.data;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

public class Category {
    private Sport sport;
    private Integer id;
    private String name;
    private List<Tournament> tournaments;

    public Integer getId() {
        return id;
    }

    @XmlAttribute(name = "CategoryId")
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    @XmlElement(name = "Tournament")
    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public Sport getSport() {
        return sport;
    }

    @XmlTransient
    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        this.sport = (Sport) parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        if (tournaments != null ? !tournaments.equals(category.tournaments) : category.tournaments != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (tournaments != null ? tournaments.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tournaments=" + tournaments +
                '}';
    }
}
