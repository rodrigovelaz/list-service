package org.rodrigovelaz.listservice.business.service.impl;

import org.rodrigovelaz.listservice.business.service.ItemService;
import org.rodrigovelaz.listservice.persistence.model.Item;
import org.rodrigovelaz.listservice.persistence.model.List;
import org.rodrigovelaz.listservice.persistence.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {

	//private Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public Long countByListAndValue(List list, String value) {
		return itemRepository.countByListAndValue(list, value);
	}
	
	@Override
	public java.util.List<Item> getByList(List list) {
		return itemRepository.getByList(list);
	}
	
}