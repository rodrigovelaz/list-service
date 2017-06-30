package org.rodrigovelaz.listservice.persistence.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.rodrigovelaz.listservice.persistence.model.enums.ListType;

@Entity
@Table(name="list")
public class List {

	@Id
	@GeneratedValue
	protected Long id;
	
	@Column(unique=true, nullable = false)
	private String name;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private ListType type;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="list")
	private java.util.List<Item> items;

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

	public java.util.List<Item> getItems() {
		return items;
	}

	public void setItems(java.util.List<Item> items) {
		this.items = items;
	}

	public ListType getType() {
		return type;
	}

	public void setType(ListType type) {
		this.type = type;
	}
	
}
