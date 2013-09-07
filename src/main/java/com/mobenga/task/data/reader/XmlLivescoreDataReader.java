package com.mobenga.task.data.reader;

import com.mobenga.task.data.LivescoreData;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.StreamFilter;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.Source;
import java.util.List;

public class XmlLivescoreDataReader implements LivescoreDataReader {
    protected Source dataSource;
    protected List<StreamFilter> filters;

    public XmlLivescoreDataReader(Source dataSource) {
        this.dataSource = dataSource;
    }

    public XmlLivescoreDataReader(Source dataSource, List<StreamFilter> filters) {
        this.dataSource = dataSource;
        this.filters = filters;
    }

    @Override
    public LivescoreData readData() {
        LivescoreData livescoreData = null;
        try {
            Unmarshaller unmarshaller = createUnmarshaller();
            XMLStreamReader streamReader = createStreamReader();
            livescoreData = (LivescoreData) unmarshaller.unmarshal(streamReader);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return livescoreData;
    }

    public Source getDataSource() {
        return dataSource;
    }

    public void setDataSource(Source dataSource) {
        this.dataSource = dataSource;
    }

    public List<StreamFilter> getFilters() {
        return filters;
    }

    public void setFilters(List<StreamFilter> filters) {
        this.filters = filters;
    }

    protected Unmarshaller createUnmarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(LivescoreData.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        return unmarshaller;
    }

    protected XMLStreamReader createStreamReader() throws XMLStreamException {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(dataSource);
        if (filters != null) {
            for (StreamFilter filter : filters) {
                xmlStreamReader = xmlInputFactory.createFilteredReader(xmlStreamReader, filter);
            }
        }
        return xmlStreamReader;
    }
}
