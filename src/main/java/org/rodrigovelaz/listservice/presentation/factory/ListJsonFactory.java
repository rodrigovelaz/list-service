package org.rodrigovelaz.listservice.presentation.factory;

import java.util.ArrayList;

import org.rodrigovelaz.listservice.persistence.model.List;
import org.rodrigovelaz.listservice.presentation.json.ListJson;


public class ListJsonFactory {

	public static List create(ListJson listJson) {
		List list = new List();
		list.setName(listJson.getName());
		list.setType(listJson.getType());
		return list;
	}
	
	public static ListJson create(List list) {
		ListJson json = new ListJson();
		json.setId(list.getId());
		json.setName(list.getName());
		json.setType(list.getType());
		return json;
	}
	
	public static java.util.List<ListJson> create(java.util.List<List> list) {
		
		java.util.List<ListJson> jsons = new ArrayList<ListJson>();
		
		for (List l : list) {
			jsons.add(create(l));
		}
		
		return jsons;
	}
	
}
