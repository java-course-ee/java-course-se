package com.junior.docfinder.view;

import com.junior.docfinder.business.DocFinder;
import com.junior.docfinder.filter.DocFilter;

/**
 * Created by Intern on 10.10.14.
 */
public class DocView {

    public void showDocuments() {

        DocFinder docFinder = new DocFinder();

        DocFilter docFilter = new DocFilter();
        docFilter.setDocName("skdhbf");

        docFinder.findDocuments(docFilter);

    }

}
