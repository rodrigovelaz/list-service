package org.rodrigovelaz.listservice.presentation.json;

import org.rodrigovelaz.listservice.persistence.model.enums.ListType;

public class ListJson {
	
	protected Long id;
	private String name;
	private ListType type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ListType getType() {
		return type;
	}
	public void setType(ListType type) {
		this.type = type;
	}

}
