package com.mobenga.task.data.formating;

import com.mobenga.task.data.Match;
import com.mobenga.task.data.Score;

public class ScoresMatchListComparator extends AlpabetMatchListComparator {
    @Override
    public int compare(Match o1, Match o2) {
        int compareByScoresResult = compareByScores(o1, o2);
        if (compareByScoresResult != 0) {
            return compareByScoresResult;
        }
        return super.compare(o1, o2);
    }

    protected int compareByScores(Match o1, Match o2) {
        Score score1 = o1.getScores() != null && o1.getScores().size() > 0 ? o1.getScores().get(0) : null;
        Score score2 = o2.getScores() != null && o2.getScores().size() > 0 ? o2.getScores().get(0) : null;
        if (score1 == null && score2 == null) {
            return 0;
        }
        if (score1 == null) {
            return 1;
        }
        if (score2 == null) {
            return -1;
        }
        return score2.getTeam1() + score2.getTeam2() - score1.getTeam1() - score1.getTeam2();
    }
}
