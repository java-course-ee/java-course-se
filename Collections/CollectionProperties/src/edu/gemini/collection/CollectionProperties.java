package edu.gemini.collection;

import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;

/**
 * Пример использования файла свойств
 * 
 * @author ASaburov
 */
public class CollectionProperties {

    public static void main(String[] args) throws IOException {
        CollectionProperties cp = new CollectionProperties();
        cp.propertiesTest();
        cp.propertiesResourceRU();
        cp.propertiesResourceEN();
    }

    // Простая загрузка файла - с прямым указанием имени файла
    private void propertiesTest() throws IOException {
        Properties pr = new Properties();
        pr.load(new FileReader("src/PropertiesExample.properties"));
        System.out.println("TITLE:" + pr.getProperty("title"));
    }

    // Загрузка свойств через ресурс с указанием базового имени и локализации
    // Загрузка русскоязычного ресурса - обратить внимание на new Locale("RU");
    private void propertiesResourceRU() throws IOException {
        PropertyResourceBundle prb = (PropertyResourceBundle) PropertyResourceBundle
                .getBundle("PropertiesExample", new Locale("RU"));
        System.out.println("TITLE:" + prb.getObject("title"));
    }
    
    // Загрузка англоязычного ресурса - обратить внимание на new Locale("EN");
    private void propertiesResourceEN() throws IOException {
        PropertyResourceBundle prb = (PropertyResourceBundle) PropertyResourceBundle
                .getBundle("PropertiesExample", new Locale("EN"));
        System.out.println("TITLE:" + prb.getObject("title"));
    }
}
