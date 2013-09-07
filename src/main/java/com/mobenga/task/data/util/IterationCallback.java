package com.mobenga.task.data.util;

import com.mobenga.task.data.Category;
import com.mobenga.task.data.Match;
import com.mobenga.task.data.Sport;
import com.mobenga.task.data.Tournament;

import java.util.List;

/**
 * This interface declares a simple callback class with methods
 * which will be called during  LivescoreData iteration with
 * {@link Util.iterateLivescoreData();}
 *
 * Methods {@link #allSports(java.util.List)}, {@link #allCategories(java.util.List)},
 * {@link #allTournaments(java.util.List)}, {@link #allMatches(java.util.List)} return
 * false to stop iterate this branch (true to continue).
 *
 * Methods {@link #eachSport(com.mobenga.task.data.Sport)}, {@link #eachCategory(com.mobenga.task.data.Category)},
 * {@link #eachTournament(com.mobenga.task.data.Tournament)}, {@link #eachMatch(com.mobenga.task.data.Match)}
 * return to stop iterate elements of the branch (true to continue).
 */
public interface IterationCallback {
    boolean allSports(List<Sport> sports);
    boolean allCategories(List<Category> categories);
    boolean allTournaments(List<Tournament> tournaments);
    boolean allMatches(List<Match> matches);

    boolean eachSport(Sport sport);
    boolean eachCategory(Category category);
    boolean eachTournament(Tournament tournament);
    boolean eachMatch(Match match);
}
