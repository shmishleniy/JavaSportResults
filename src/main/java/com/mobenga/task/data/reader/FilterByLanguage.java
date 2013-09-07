package com.mobenga.task.data.reader;

import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLStreamReader;

public class FilterByLanguage implements StreamFilter {
    protected String requiredLanguage;
    protected Boolean acceptElement = true;

    public FilterByLanguage(String requiredLanguage) {
        this.requiredLanguage = requiredLanguage;
    }

    @Override
    public boolean accept(XMLStreamReader reader) {
        if (reader.isStartElement()) {
            int attributeCount = reader.getAttributeCount();
            for (int attrNum = 0; attrNum < attributeCount; attrNum++) {
                if ("language".equals(reader.getAttributeLocalName(attrNum))) {
                    acceptElement = requiredLanguage.equals(reader.getAttributeValue(attrNum));
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
