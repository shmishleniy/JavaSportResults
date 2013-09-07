package com.mobenga.task.data.formating;

import com.mobenga.task.data.LivescoreData;
import com.mobenga.task.data.Match;
import com.mobenga.task.data.Score;
import com.mobenga.task.data.util.Util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MatchListFormatter implements LivescoreDataFormatter {
    private Comparator<Match> matchComparator;

    public MatchListFormatter() {
    }

    public MatchListFormatter(Comparator<Match> matchComparator) {
        this.matchComparator = matchComparator;
    }

    public Comparator<Match> getMatchComparator() {
        return matchComparator;
    }

    public void setMatchComparator(Comparator<Match> matchComparator) {
        this.matchComparator = matchComparator;
    }

    @Override
    public String format(LivescoreData livescoreData) {
        StringBuilder formattedData = new StringBuilder();
        for (Match match : getSortedMatches(livescoreData)) {
            formattedData.append(match.getTournament().getCategory().getSport().getName());
            formattedData.append(" | ");
            formattedData.append(match.getTournament().getCategory().getName());
            formattedData.append(" | ");
            formattedData.append(match.getTournament().getName());
            formattedData.append(" | ");
            formattedData.append(match.getTeam1().getName());
            formattedData.append(" - ");
            formattedData.append(match.getTeam2().getName());
            formattedData.append(" : ");
            if (match.getScores() != null && match.getScores().size() > 0) {
                Score score = match.getScores().get(0);
                formattedData.append(score.getTeam1());
                formattedData.append(" - ");
                formattedData.append(score.getTeam2());
            }
            formattedData.append(System.getProperty("line.separator"));
        }
        return formattedData.toString();
    }

    protected List<Match> getSortedMatches(LivescoreData livescoreData) {
        List<Match> matches = Util.getAllMatches(livescoreData);
        if (matchComparator != null) {
            Collections.sort(matches, matchComparator);
        }
        return matches;
    }
}
