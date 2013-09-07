package com.mobenga.task.data.reader;

import com.mobenga.task.data.*;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class XmlLivescoreDataReaderTest extends BaseLivescoreDataTest {
    public static final int SPROTS_COUNT = 1;
    public static final int CATEGORIES_COUNT = 2;
    public static final int TOURNAMENT_COUNT = 1;
    public static final int MATCHES_COUNT = 1;
    public static final String SOCCER = "Soccer";
    public static final String AUSTRALIA = "Australia";
    public static final String FOTBOLL = "Fotboll";
    public static final String AUSTRALIEN = "Australien";
    public static final String EN_LANGUAGE = "en";
    public static final String SE_LANGUAGE = "se";
    public static final String CURRENT_SCORES = "Current";
    public static final int SCORES_COUNT_ALL = 3;
    public static final int CURRENT_SCORES_COUNT = 1;

    @Test
    public void testReadDataWithoutFilters() throws Exception {
        LivescoreDataReader livescoreDataReader = new XmlLivescoreDataReader(createStreamSource());
        LivescoreData livescoreData = livescoreDataReader.readData();
        commonAssertions(livescoreData);
        scoresAssertions(livescoreData, SCORES_COUNT_ALL);
    }

    @Test
    public void testReadDataWithEnglishLanguageFilter() throws Exception {
        LivescoreDataReader enLivescoreDataReader = new XmlLivescoreDataReader(createStreamSource(), createFilters(EN_LANGUAGE));
        LivescoreData enLivescoreData = enLivescoreDataReader.readData();
        commonAssertions(enLivescoreData);
        languageAssertions(enLivescoreData, SOCCER, AUSTRALIA);
    }

    @Test
    public void testReadDataWithSwedishLanguageFilter() throws Exception {
        LivescoreDataReader seLivescoreDataReader = new XmlLivescoreDataReader(createStreamSource(), createFilters(SE_LANGUAGE));
        LivescoreData seLivescoreData = seLivescoreDataReader.readData();
        commonAssertions(seLivescoreData);
        languageAssertions(seLivescoreData, FOTBOLL, AUSTRALIEN);
    }

    @Test
    public void testReadDataWithLanguageAndScoresTypeFilters() throws Exception {
        LivescoreDataReader livescoreDataReader = new XmlLivescoreDataReader(createStreamSource(), createFilters(EN_LANGUAGE, CURRENT_SCORES));
        LivescoreData livescoreData = livescoreDataReader.readData();
        commonAssertions(livescoreData);
        scoresAssertions(livescoreData, CURRENT_SCORES_COUNT);
    }

    protected void scoresAssertions(LivescoreData livescoreData, int expectedScoresCount) {
        List<Score> scoreList =
                livescoreData.getSports().get(0).
                        getCategories().get(0).
                        getTournaments().get(0).
                        getMatches().get(0).getScores();
        assertEquals(expectedScoresCount, scoreList.size());
    }

    protected void languageAssertions(LivescoreData livescoreData, String expectedSportName, String expectedCountryName) {
        Sport sport = livescoreData.getSports().get(0);
        assertEquals(expectedSportName, sport.getName());
        Category category = sport.getCategories().get(0);
        assertEquals(expectedCountryName, category.getName());
    }

    protected void commonAssertions(LivescoreData livescoreData) {
        assertNotNull(livescoreData);
        List<Sport> sports = livescoreData.getSports();
        assertEquals(SPROTS_COUNT, sports.size());
        List<Category> categories = sports.get(0).getCategories();
        assertEquals(CATEGORIES_COUNT, categories.size());
        List<Tournament> tournaments = categories.get(0).getTournaments();
        assertEquals(TOURNAMENT_COUNT, tournaments.size());
        List<Match> matches = tournaments.get(0).getMatches();
        assertEquals(MATCHES_COUNT, matches.size());
    }
}
