package com.mobenga.task;

import com.mobenga.task.data.LivescoreData;
import com.mobenga.task.data.formating.*;
import com.mobenga.task.data.reader.FilterByLanguage;
import com.mobenga.task.data.reader.FilterByScoresType;
import com.mobenga.task.data.reader.LivescoreDataReader;
import com.mobenga.task.data.reader.XmlLivescoreDataReader;

import javax.xml.stream.StreamFilter;
import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;
import java.util.List;

public class SportResultProcessor {
    public static final String LANGUAGE = "en";
    public static final String SCORES_TYPE = "Current";
    public static final String DATA_SOURCE = "big-data.xml";

    private LivescoreDataReader livescoreDataReader;
    private LivescoreDataFormatter matchListAlphabetFormatter;
    private LivescoreDataFormatter matchListScoresFormatter;
    private LivescoreDataFormatter topListFormatter;

    private StringDataWriter matchListAlphabetWriter;
    private StringDataWriter matchListScoresWriter;
    private StringDataWriter topListWriter;

    public SportResultProcessor() {
        livescoreDataReader = new XmlLivescoreDataReader(createStreamSource(), createFilters(LANGUAGE, SCORES_TYPE));
        matchListAlphabetFormatter = new MatchListFormatter(new AlpabetMatchListComparator());
        matchListScoresFormatter = new MatchListFormatter(new ScoresMatchListComparator());
        topListFormatter = new TopListFormatter();
        matchListAlphabetWriter = new SimpleFileWriter("big-matchlist-alphasort.txt");
        matchListScoresWriter = new SimpleFileWriter("big-matchlist-goalsort.txt");
        topListWriter = new SimpleFileWriter("big-toplist.txt");
    }

    public void process() {
        LivescoreData livescoreData = livescoreDataReader.readData();
        if (livescoreData == null) {
            System.out.println("There was an error.");
            return;
        }
        matchListAlphabetWriter.writeData(matchListAlphabetFormatter.format(livescoreData));
        matchListScoresWriter.writeData(matchListScoresFormatter.format(livescoreData));
        topListWriter.writeData(topListFormatter.format(livescoreData));
        System.out.println("Processing finished.");
    }

    protected StreamSource createStreamSource() {
        return new StreamSource(ClassLoader.getSystemResourceAsStream(DATA_SOURCE));
    }

    protected List<StreamFilter> createFilters(String language) {
        List<StreamFilter> filters = new ArrayList<StreamFilter>(2);
        filters.add(new FilterByLanguage(language));
        return filters;
    }

    protected List<StreamFilter> createFilters(String language, String scoresType) {
        List<StreamFilter> filters = createFilters(language);
        filters.add(new FilterByScoresType(scoresType));
        return filters;
    }
}
