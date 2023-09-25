package com.paryshkin.springMVC.models;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLHandler
{
    public static void saveToXML(Calculator calculator, String filePath) throws Exception
    {
        JAXBContext context = JAXBContext.newInstance(Calculator.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(calculator, new File(filePath));
    }

    public static Calculator loadFromXML(String filePath) throws Exception
    {
        JAXBContext context = JAXBContext.newInstance(Calculator.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (Calculator) unmarshaller.unmarshal(new File(filePath));
    }
}
