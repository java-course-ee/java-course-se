package edu.gemini.xml;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DomExample {

    public static void main(String[] args) {
        try {
            // Создается построитель документа
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            // Создается дерево DOM документа из файла
            Document document = documentBuilder.parse("BookCatalog.xml");

            // Получаем корневой элемент
            Node root = document.getFirstChild();
            System.out.println("ROOT:" + root.getNodeName());

            // Просматриваем все подэлементы корневого - т.е. книги
            NodeList children = root.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                Node child = children.item(i);
                if (child.getNodeType() != Node.TEXT_NODE) {
                    System.out.println("CHILD:" + child.getNodeName());
                }
            }

            // СОздаем новую книгу по элементам
            // Сама книга <Book>
            Element book = document.createElement("Book");
            // <Title>
            Element title = document.createElement("Title");
            // Устанавливаем значение текста внутри тега
            title.setTextContent("Incredible book about Java");
            // <Author>
            Element author = document.createElement("Author");
            author.setTextContent("Unknown author");
            // <Date>
            Element date = document.createElement("Date");
            date.setTextContent("2012");
            // <ISBN>
            Element isbn = document.createElement("ISBN");
            isbn.setTextContent("0-06-999999-9");
            // <Publisher>
            Element publisher = document.createElement("Publisher");
            publisher.setTextContent("Gemini publisher");
            // <Cost>
            Element cost = document.createElement("Cost");
            cost.setAttribute("currency", "RUB");
            // Устанавливает аттрибут
            cost.setTextContent("1500");

            // Добавляем внутренние элементы книги в элемент <Book>
            book.appendChild(title);
            book.appendChild(author);
            book.appendChild(date);
            book.appendChild(isbn);
            book.appendChild(publisher);
            book.appendChild(cost);
            // Добавляем книгу в корневой элемент
            root.appendChild(book);
            
            // Записываем XML в файл
            writeDocument(document);

        } catch (ParserConfigurationException ex) {
            ex.printStackTrace(System.out);
        } catch (SAXException ex) {
            ex.printStackTrace(System.out);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private static void writeDocument(Document document) throws TransformerFactoryConfigurationError {
        DOMSource source = new DOMSource(document);
        FileOutputStream fos = null;
        try {
            Transformer tr = TransformerFactory.newInstance().newTransformer();
            fos = new FileOutputStream("other.xml");
            StreamResult result = new StreamResult(fos);
            tr.transform(source, result);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    ex.printStackTrace(System.out);
                }
            }
        }
    }
}
