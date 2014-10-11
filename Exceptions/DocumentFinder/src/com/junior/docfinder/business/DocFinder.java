package com.junior.docfinder.business;

import com.junior.docfinder.dao.DocFinderDAO;
import com.junior.docfinder.dao.DocFinderDAOFactory;
import com.junior.docfinder.entity.DocDescription;
import com.junior.docfinder.filter.DocFilter;

import java.util.List;

public class DocFinder {

    public DocDescription[] findDocuments(DocFilter filter) {
        DocFinderDAOFactory factory = DocFinderDAOFactory.getInstance();
        DocFinderDAO dao = factory.getDAO();
        DocDescription[] list = dao.findDocuments(filter);
        return list;
    }
}
