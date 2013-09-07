package com.mobenga.task.data.util;

import com.mobenga.task.data.BaseLivescoreDataTest;
import com.mobenga.task.data.LivescoreData;
import com.mobenga.task.data.Match;
import com.mobenga.task.data.reader.LivescoreDataReader;
import com.mobenga.task.data.reader.XmlLivescoreDataReader;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UtilTest extends BaseLivescoreDataTest {
    public static final String EN_LANGUAGE = "en";
    public static final String CURRENT_SCORES = "Current";
    public static final int EXPECTED_MATCHES_COUNT = 3;

    LivescoreData livescoreData;

    @Before
    public void setUp() {
        LivescoreDataReader livescoreDataReader = new XmlLivescoreDataReader(createStreamSource(), createFilters(EN_LANGUAGE, CURRENT_SCORES));
        livescoreData = livescoreDataReader.readData();
    }

    @Test
    public void testGetMatches() throws Exception {
        List<Match> matches = Util.getAllMatches(livescoreData);
        assertNotNull(matches);
        assertEquals(EXPECTED_MATCHES_COUNT, matches.size());
    }
}
