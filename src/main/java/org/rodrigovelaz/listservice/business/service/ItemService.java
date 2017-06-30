package org.rodrigovelaz.listservice.business.service;

import org.rodrigovelaz.listservice.persistence.model.Item;
import org.rodrigovelaz.listservice.persistence.model.List;

public interface ItemService {

	public Long countByListAndValue(List list, String value);
	public java.util.List<Item> getByList(List list);
	
}
