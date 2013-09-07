package com.mobenga.task.data;

import com.mobenga.task.data.reader.FilterByLanguage;
import com.mobenga.task.data.reader.FilterByScoresType;

import javax.xml.stream.StreamFilter;
import javax.xml.transform.stream.StreamSource;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLivescoreDataTest {
    protected StreamSource createStreamSource() {
        return new StreamSource(ClassLoader.getSystemResourceAsStream("test-data.xml"));
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
