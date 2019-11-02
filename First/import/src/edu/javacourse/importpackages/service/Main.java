package edu.javacourse.importpackages.service;

import edu.javacourse.importpackages.dao.DataReader;

public class Main {
    public static void main(String[] args) {
        DataReader reader = new DataReader();
        System.out.println(reader.readData());
    }
}
