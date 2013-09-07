package com.mobenga.task.data;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class Score {
    private String type;
    private Integer team1;
    private Integer team2;

    public String getType() {
        return type;
    }

    @XmlAttribute(name = "type")
    public void setType(String type) {
        this.type = type;
    }

    public Integer getTeam1() {
        return team1;
    }

    @XmlElement(name = "Team1")
    public void setTeam1(Integer team1) {
        this.team1 = team1;
    }

    public Integer getTeam2() {
        return team2;
    }

    @XmlElement(name = "Team2")
    public void setTeam2(Integer team2) {
        this.team2 = team2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Score score = (Score) o;

        if (team1 != null ? !team1.equals(score.team1) : score.team1 != null) return false;
        if (team2 != null ? !team2.equals(score.team2) : score.team2 != null) return false;
        if (type != null ? !type.equals(score.type) : score.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (team1 != null ? team1.hashCode() : 0);
        result = 31 * result + (team2 != null ? team2.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Score{" +
                "type='" + type + '\'' +
                ", team1=" + team1 +
                ", team2=" + team2 +
                '}';
    }
}
