package org.rodrigovelaz.listservice.business.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.rodrigovelaz.listservice.business.exception.ListServiceException;
import org.rodrigovelaz.listservice.business.service.ItemService;
import org.rodrigovelaz.listservice.business.service.ListService;
import org.rodrigovelaz.listservice.persistence.model.Item;
import org.rodrigovelaz.listservice.persistence.model.List;
import org.rodrigovelaz.listservice.persistence.model.enums.ListType;
import org.rodrigovelaz.listservice.persistence.repository.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ListServiceImpl implements ListService {

	//private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private ListRepository repository;
	
	@Autowired
	private ItemService itemService;
	
	@Override
	public java.util.List<List> findAll() {
		return this.repository.findAll();
	}
	
	@Override
	public List save(List list) {
		return this.repository.save(list);
	}
	
	@Override
	public List findByNameMandatory(String listName) throws ListServiceException {
		List list = this.repository.findByName(listName);
		if (list == null) throw new ListServiceException("List not found, name: " + listName);
		return list;
	}
	
	@Override
	public Boolean isValid(List list, String value) throws ListServiceException {
		
		if (list.getType().equals(ListType.BLACKLIST)) {
			
			Long count = itemService.countByListAndValue(list, value);
			return (count == 0);
		}
		else if (list.getType().equals(ListType.WHITELIST)) {

			Long count = itemService.countByListAndValue(list, value);
			return (count > 0);
		}
		else if (list.getType().equals(ListType.REGULAR_EXPRESSION)) {
			
			java.util.List<Item> items = this.itemService.getByList(list);
			
			Boolean matchs = false;
			
			for (Item item : items) {
				
				 Pattern pattern = Pattern.compile(item.getValue());
				 Matcher matcher = pattern.matcher(value);
				 
				 matchs = matchs || matcher.matches();
			}
			
			return matchs;
		}
		else {
			throw new ListServiceException("Invalid list type: " + list.getType() );
		}
	}

}