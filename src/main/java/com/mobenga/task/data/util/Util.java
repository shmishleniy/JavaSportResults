package com.mobenga.task.data.util;

import com.mobenga.task.data.*;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Util {
    private Util() {
    }

    public static List<Match> getAllMatches(LivescoreData livescoreData) {
        final List<Match> returnMatches = new LinkedList<Match>();
        iterateLivescoreData(livescoreData, new BaseIterationCallback() {
            @Override
            public boolean allMatches(List<Match> matches) {
                returnMatches.addAll(matches);
                return false;
            }
        });
        return returnMatches;
    }

    public static void iterateLivescoreData(LivescoreData livescoreData, IterationCallback iterationCallback) {
        if (livescoreData != null) {
            iterateSports(livescoreData.getSports(), iterationCallback);
        }
    }

    public static void iterateSports(List<Sport> sports, IterationCallback iterationCallback) {
        if (sports == null) return;
        if (!iterationCallback.allSports(sports)) {
            return;
        }
        boolean continueIterateEach = true;
        for (Sport sport : sports) {
            if (sport != null) {
                if (continueIterateEach) {
                    continueIterateEach = iterationCallback.eachSport(sport);
                }
                iterateCatagories(sport.getCategories(), iterationCallback);
            }
        }
    }

    public static void iterateCatagories(List<Category> categories, IterationCallback iterationCallback) {
        if (categories == null) return;
        if (!iterationCallback.allCategories(categories)) {
            return;
        }
        boolean continueIterateEach = true;
        for (Category category : categories) {
            if (category != null) {
                if (continueIterateEach) {
                    continueIterateEach = iterationCallback.eachCategory(category);
                }
                iterateTournaments(category.getTournaments(), iterationCallback);
            }
        }
    }

    public static void iterateTournaments(List<Tournament> tournaments, IterationCallback iterationCallback) {
        if (tournaments == null) return;
        if (!iterationCallback.allTournaments(tournaments)) {
            return;
        }
        boolean continueIterateEach = true;
        for (Tournament tournament : tournaments) {
            if (tournament != null) {
                if (continueIterateEach) {
                    continueIterateEach = iterationCallback.eachTournament(tournament);
                }
                iterateMatches(tournament.getMatches(), iterationCallback);
            }
        }
    }

    public static void iterateMatches(List<Match> matches, IterationCallback iterationCallback) {
        if (matches == null) return;
        if (!iterationCallback.allMatches(matches)) {
            return;
        }
        boolean continueIterateEach = true;
        for (Match match : matches) {
            if (match != null) {
                if (continueIterateEach) {
                    continueIterateEach = iterationCallback.eachMatch(match);
                }
            }
        }
    }
}
