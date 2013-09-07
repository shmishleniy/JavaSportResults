package com.mobenga.task.data;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

public class Tournament {
    private Category category;
    private Integer id;
    private String name;
    private List<Match> matches;

    public Integer getId() {
        return id;
    }

    @XmlAttribute(name = "TournamentId")
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

    public List<Match> getMatches() {
        return matches;
    }

    @XmlElement(name = "Match")
    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public Category getCategory() {
        return category;
    }

    @XmlTransient
    public void setCategory(Category category) {
        this.category = category;
    }

    public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        this.category = (Category) parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tournament that = (Tournament) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (matches != null ? !matches.equals(that.matches) : that.matches != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (matches != null ? matches.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", matches=" + matches +
                '}';
    }
}
