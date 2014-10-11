package com.junior.docfinder.dao;

import com.junior.docfinder.business.DocFinder;

public class DocFinderDAOFactory {

    private static DocFinderDAOFactory instance;

    private DocFinderDAOFactory() {
    }

    public static synchronized DocFinderDAOFactory getInstance() {
        if(instance == null) {
            instance = new DocFinderDAOFactory();
        }
        return instance;
    }

    public DocFinderDAO getDAO() {
        return new DocFinderDAOFile();
    }
}
