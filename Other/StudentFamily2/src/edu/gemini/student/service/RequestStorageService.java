package edu.gemini.student.service;

import edu.gemini.student.person.ServiceClient;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Класс для хранения списка заявлений
 *
 * @author ASaburov
 */
public class RequestStorageService {

    private ServiceClient[] scList = new ServiceClient[10];
    private Integer currentPos = 0;

    public RequestStorageService() {
        loadServiceClient();
    }

    private void loadServiceClient() {
        // "Соединяем" поток ObjectInputStream с FileInputStream
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("D:/JavaCourseSE/ServiceClient.dat");
            // "Соединяем" поток ObjectInputStream с FileInputStream
            ObjectInputStream ois = new ObjectInputStream(fis);
            for (int i = 0; i < 10; i++) {
                try {
                    scList[i] = (ServiceClient) ois.readObject();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }

            ois.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ServiceClient getUncheckedClient() {
        System.out.println("Read client:" + currentPos);
        if (currentPos == 10) {
            return null;
        }
        return scList[currentPos++];
    }

    public void updateClient(ServiceClient client, boolean accept) {
        System.out.println("Клиент проверен");
    }
}
