package org.rodrigovelaz.listservice.persistence.repository;

import org.rodrigovelaz.listservice.persistence.model.Item;
import org.rodrigovelaz.listservice.persistence.model.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
	
	public Long countByListAndValue(List list, String value);
	public java.util.List<Item> getByList(List list);
	
}
