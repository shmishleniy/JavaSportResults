package com.mobenga.task.data;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

public class Sport {
    private LivescoreData livescoreData;
    private Integer id;
    private String name;
    private List<Category> categories;

    public Integer getId() {
        return id;
    }

    @XmlAttribute(name = "SportId")
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

    public List<Category> getCategories() {
        return categories;
    }

    @XmlElement(name = "Category")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public LivescoreData getLivescoreData() {
        return livescoreData;
    }

    @XmlTransient
    public void setLivescoreData(LivescoreData livescoreData) {
        this.livescoreData = livescoreData;
    }

    public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        this.livescoreData = (LivescoreData) parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sport sport = (Sport) o;

        if (categories != null ? !categories.equals(sport.categories) : sport.categories != null) return false;
        if (id != null ? !id.equals(sport.id) : sport.id != null) return false;
        if (name != null ? !name.equals(sport.name) : sport.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Sport{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", categories=" + categories +
                '}';
    }
}
