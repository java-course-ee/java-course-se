package com.junior.docfinder.dao;

import com.junior.docfinder.entity.DocDescription;
import com.junior.docfinder.filter.DocFilter;

import javax.naming.directory.InvalidSearchFilterException;
import java.util.List;

public interface DocFinderDAO {
    public DocDescription[] findDocuments(DocFilter filter) throws DAOException, FilterException;
}
