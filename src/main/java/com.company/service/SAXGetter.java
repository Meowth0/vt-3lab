package com.company.service;

import com.company.model.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class SAXGetter implements DataGetter {
    private String testsFileName = "tests.xml";
    private String xsdFileName = "xsdSchema.xsd";

    public List<Test> getData(){
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;

        try {
            parser = factory.newSAXParser();
        } catch (SAXException | ParserConfigurationException e) {
            e.printStackTrace();
        }

        XMLHandler handler = new XMLHandler();

        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File testsFile = new File(requireNonNull(classLoader.getResource(testsFileName)).getFile());
            File xsdFile = new File(requireNonNull(classLoader.getResource(xsdFileName)).getFile());

            if (new XsdValidator().validateXMLByXSD(testsFile, xsdFile))
                parser.parse(testsFile, handler);
            else {
                System.out.println("error");
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace();
        }
        return handler.getTests();
    }
}
