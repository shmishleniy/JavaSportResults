package com.mobenga.task.data.formating;

import com.mobenga.task.data.Match;

import java.util.Comparator;

public class AlpabetMatchListComparator implements Comparator<Match> {
    @Override
    public int compare(Match o1, Match o2) {
        int alphabeticBySport = compareAlphabeticBySport(o1, o2);
        if (alphabeticBySport != 0) {
            return alphabeticBySport;
        }
        int alphabetic = compareAlphabetic(o1, o2);
        if (alphabetic != 0) {
            return alphabetic;
        }
        return 0;
    }

    protected int compareAlphabeticBySport(Match o1, Match o2) {
        int compareBySport = o1.getTournament().getCategory().getSport().getName()
                .compareTo(o2.getTournament().getCategory().getSport().getName());
        if (compareBySport != 0) {
            return compareBySport;
        }
        return 0;
    }

    protected int compareAlphabetic(Match o1, Match o2) {
        int compareByCategory = o1.getTournament().getCategory().getName()
                .compareTo(o2.getTournament().getCategory().getName());
        if (compareByCategory != 0) {
            return compareByCategory;
        }
        int compareByTournament = o1.getTournament().getName().compareTo(o2.getTournament().getName());
        if (compareByTournament != 0) {
            return compareByTournament;
        }
        int compareByTeam1 = o1.getTeam1().getName().compareTo(o2.getTeam1().getName());
        if (compareByTeam1 != 0) {
            return compareByTeam1;
        }
        return o1.getTeam2().getName()
                .compareTo(o2.getTeam2().getName());
    }
}
