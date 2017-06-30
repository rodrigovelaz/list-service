package org.rodrigovelaz.listservice.business.service;

import org.rodrigovelaz.listservice.business.exception.ListServiceException;
import org.rodrigovelaz.listservice.persistence.model.List;

public interface ListService {
	
	public java.util.List<List> findAll();
	public List save(List list);
	public List findByNameMandatory(String listName) throws ListServiceException;
	public Boolean isValid(List list, String value) throws ListServiceException;

}
