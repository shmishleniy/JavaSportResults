package com.mobenga.task.data.util;

import com.mobenga.task.data.Category;
import com.mobenga.task.data.Match;
import com.mobenga.task.data.Sport;
import com.mobenga.task.data.Tournament;

import java.util.List;

/**
 * Implementation of IterationCallback.
 * Iterating only on the branches, elements excluded.
 * @see IterationCallback
 */
public class BaseIterationCallback implements IterationCallback {
    @Override
    public boolean eachSport(Sport sport) {
        return false;
    }

    @Override
    public boolean eachCategory(Category category) {
        return false;
    }

    @Override
    public boolean eachTournament(Tournament tournament) {
        return false;
    }

    @Override
    public boolean eachMatch(Match match) {
        return false;
    }

    @Override
    public boolean allSports(List<Sport> sports) {
        return true;
    }

    @Override
    public boolean allCategories(List<Category> categories) {
        return true;
    }

    @Override
    public boolean allTournaments(List<Tournament> tournaments) {
        return true;
    }

    @Override
    public boolean allMatches(List<Match> matches) {
        return true;
    }
}
