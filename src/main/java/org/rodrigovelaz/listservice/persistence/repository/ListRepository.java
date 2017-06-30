package org.rodrigovelaz.listservice.persistence.repository;

import org.rodrigovelaz.listservice.persistence.model.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListRepository extends JpaRepository<List, Long> {
	
	public List findByName(String name);
	
}
