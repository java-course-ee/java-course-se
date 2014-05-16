package edu.gemini.xml;

import java.io.FileWriter;
import java.io.IOException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Пример записи XML-файла с помощью технологии StAX
 * @author ASaburov
 */
public class StaxExample {

    public static void main(String[] args) {
        try {
            XMLOutputFactory output = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = output.createXMLStreamWriter(new FileWriter("result.xml"));
            writer.writeStartDocument();
            writer.writeStartElement("a");
            writer.writeAttribute("b", "blah");
            writer.setPrefix("d", "http://c");
            writer.writeEmptyElement("d");
            writer.writeAttribute("chris", "fry");
            writer.writeCharacters("Jean Arp");
            writer.writeEndElement();
            writer.flush();
        } catch (XMLStreamException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
