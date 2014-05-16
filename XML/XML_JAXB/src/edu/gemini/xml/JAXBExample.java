package edu.gemini.xml;

import edu.gemini.xml.jaxb.Book;
import edu.gemini.xml.jaxb.BookCatalogue;
import edu.gemini.xml.jaxb.Cost;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class JAXBExample {

    public static void main(String[] args) {
        {
            InputStream is = null;
            OutputStream os = null;
            try {
                // Подготавливаем файлы для записи
                is = new FileInputStream("BookCatalog.xml");
                os = new FileOutputStream("otherCatalog.xml");

                // Пример чтения файла
                readXML(is);

                // Пример записи файла
                writeXML(os);

            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (JAXBException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    is.close();
                    os.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }

    private static void readXML(InputStream is) throws JAXBException {
        // Подготавливаем необходимый набор объектов для чтения
        JAXBContext jc = JAXBContext.newInstance("edu.gemini.xml.jaxb");
        Unmarshaller u = jc.createUnmarshaller();
        
        // Считываем файл в иерархию объектов
        BookCatalogue po = (BookCatalogue) u.unmarshal(is);
        
        // Убеждаемся, что объекты есть
        System.out.println("Author:" + po.getBook().get(0).getAuthor());
    }

    private static void writeXML(OutputStream os) throws JAXBException, FileNotFoundException {
        // Подготавливаем необходимый набор объектов для записи
        JAXBContext jc = JAXBContext.newInstance("edu.gemini.xml.jaxb");
        Marshaller m = jc.createMarshaller();

        // Создаем новый набор элементов для записи
        BookCatalogue bc = new BookCatalogue();
        Book b = new Book();
        b.setAuthor("First");
        Cost c = new Cost();
        c.setValue(new BigDecimal(1001));
        b.setCost(c);
        bc.getBook().add(b);

        // И записываем это в файл XML
        m.marshal(bc, os);
    }
}
