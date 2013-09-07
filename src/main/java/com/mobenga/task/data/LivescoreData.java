package com.mobenga.task.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "LivescoreData")
public class LivescoreData {
    protected List<Sport> sports;

    public List<Sport> getSports() {
        return sports;
    }

    @XmlElement(name = "Sport")
    public void setSports(List<Sport> sports) {
        this.sports = sports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LivescoreData that = (LivescoreData) o;

        if (sports != null ? !sports.equals(that.sports) : that.sports != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return sports != null ? sports.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "LivescoreData{" +
                "sports=" + sports +
                '}';
    }
}
