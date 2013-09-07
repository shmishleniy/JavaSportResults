package com.mobenga.task.data;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlTransient;
import java.util.Date;
import java.util.List;

public class Match {
    private Tournament tournament;
    private Integer id;
    private Date matchDate;
    private Team team1;
    private Team team2;
    private Status status;
    private Integer winner;
    private List<Score> scores;

    public Integer getId() {
        return id;
    }

    @XmlAttribute(name = "MatchId")
    public void setId(Integer id) {
        this.id = id;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    @XmlElement(name = "MatchDate")
    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public Team getTeam1() {
        return team1;
    }

    @XmlElement(name = "Team1")
    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    @XmlElement(name = "Team2")
    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Status getStatus() {
        return status;
    }

    @XmlElement(name = "Status")
    public void setStatus(Status status) {
        this.status = status;
    }

    public Integer getWinner() {
        return winner;
    }

    @XmlElement(name = "Winner")
    public void setWinner(Integer winner) {
        this.winner = winner;
    }

    public List<Score> getScores() {
        return scores;
    }

    @XmlElementWrapper(name = "Scores")
    @XmlElement(name = "Score")
    public void setScores(List<Score> scores) {
        this.scores = scores;
    }

    public Tournament getTournament() {
        return tournament;
    }

    @XmlTransient
    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        this.tournament = (Tournament) parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Match match = (Match) o;

        if (id != null ? !id.equals(match.id) : match.id != null) return false;
        if (matchDate != null ? !matchDate.equals(match.matchDate) : match.matchDate != null) return false;
        if (scores != null ? !scores.equals(match.scores) : match.scores != null) return false;
        if (status != null ? !status.equals(match.status) : match.status != null) return false;
        if (team1 != null ? !team1.equals(match.team1) : match.team1 != null) return false;
        if (team2 != null ? !team2.equals(match.team2) : match.team2 != null) return false;
        if (winner != null ? !winner.equals(match.winner) : match.winner != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (matchDate != null ? matchDate.hashCode() : 0);
        result = 31 * result + (team1 != null ? team1.hashCode() : 0);
        result = 31 * result + (team2 != null ? team2.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (winner != null ? winner.hashCode() : 0);
        result = 31 * result + (scores != null ? scores.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Match{" +
                "id=" + id +
                ", matchDate=" + matchDate +
                ", team1=" + team1 +
                ", team2=" + team2 +
                ", status=" + status +
                ", winner=" + winner +
                ", scores=" + scores +
                '}';
    }
}
