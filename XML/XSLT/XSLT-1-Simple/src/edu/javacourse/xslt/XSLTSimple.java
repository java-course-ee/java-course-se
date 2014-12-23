package edu.javacourse.xslt;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * @author Artem Pronchakov | email/xmpp: artem.pronchakov@calisto.email
 */
public class XSLTSimple {

    public static void main(String[] args) throws TransformerException {

//        System.setProperty("javax.xml.transform.TransformerFactory", "net.sf.saxon.TransformerFactoryImpl");
        System.setProperty("javax.xml.transform.TransformerFactory", "org.apache.xalan.processor.TransformerFactoryImpl");

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer(new StreamSource(new File("XML/XSLT/XSLT-1-Simple/resources/simple.xsl")));

        System.out.println("Transformer: " + transformer.getClass().getCanonicalName());

        transformer.transform(new StreamSource(new File("XML/XSLT/XSLT-1-Simple/resources/data.xml")), new StreamResult(System.out));

    }

}
