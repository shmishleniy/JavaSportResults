package com.mobenga.task.data.reader;

import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLStreamReader;

public class FilterByScoresType implements StreamFilter {
    protected String requiredScoresType;
    protected Boolean acceptElement = true;

    public FilterByScoresType(String requiredScoresType) {
        this.requiredScoresType = requiredScoresType;
    }

    @Override
    public boolean accept(XMLStreamReader reader) {
        if (reader.isStartElement() && "Score".equals(reader.getLocalName())) {
            int attributeCount = reader.getAttributeCount();
            for (int attrNum = 0; attrNum < attributeCount; attrNum++) {
                if ("type".equals(reader.getAttributeLocalName(attrNum))) {
                    acceptElement = requiredScoresType.equals(reader.getAttributeValue(attrNum));
                    return acceptElement;
                }
            }
        } else if (reader.isEndElement() && !acceptElement) {
            acceptElement = true;
            return false;
        }
        return true;
    }
}
