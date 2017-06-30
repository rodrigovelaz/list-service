package org.rodrigovelaz.listservice.presentation.factory;

import org.rodrigovelaz.listservice.persistence.model.List;
import org.rodrigovelaz.listservice.presentation.json.ValidationJson;

public class ValidationJsonFactory {
	
	public static ValidationJson create(List list, String itemValue, Boolean isValid) {
		
		ValidationJson json = new ValidationJson();
		json.setIsValid(isValid);
		json.setList(ListJsonFactory.create(list));
		json.setItem(itemValue);
		return json;
	}

}
