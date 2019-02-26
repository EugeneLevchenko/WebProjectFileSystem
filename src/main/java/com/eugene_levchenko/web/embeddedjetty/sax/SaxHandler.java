package com.eugene_levchenko.web.embeddedjetty.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SaxHandler extends DefaultHandler {

    private List<Logging> logList = null;
    private Logging log = null;
    private StringBuilder stringBuilder = null;

    public List<Logging> getLogList() {
        return logList;
    }

    private boolean bLogging = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Logging")) {
            log = new Logging();
            if (logList == null)
            {
                logList = new ArrayList<>();
            }

        } else if (qName.equalsIgnoreCase("logging")) {
            bLogging = true;
        }
        stringBuilder = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName)   {
        if (!bLogging) {
            log.setLogging(stringBuilder.toString());
        }
        if (qName.equalsIgnoreCase("Logging")&&!bLogging) {
            logList.add(log);
            bLogging=true;
        }
    }

    @Override
    public void characters(char ch[], int start, int length)   {
        stringBuilder.append(new String(ch, start, length));
    }

    public static boolean enableLogging()
    {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
           SaxHandler sh=new SaxHandler();
            saxParser.parse(new File("C:\\work_eugene\\IdeaProjects\\IdeaProjectsOld\\WebProjectFileSystem\\src\\main\\resources\\hibernate.cfg.xml"), sh);
            List<Logging> logList = sh.getLogList();
            if (logList.get(0).getLogging().equals("true"))
            {
                return true;
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}