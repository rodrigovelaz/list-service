package org.rodrigovelaz.listservice.presentation.resource;

import org.rodrigovelaz.listservice.business.exception.ListServiceException;
import org.rodrigovelaz.listservice.business.service.ListService;
import org.rodrigovelaz.listservice.persistence.model.List;
import org.rodrigovelaz.listservice.presentation.factory.ListJsonFactory;
import org.rodrigovelaz.listservice.presentation.factory.ValidationJsonFactory;
import org.rodrigovelaz.listservice.presentation.json.ListJson;
import org.rodrigovelaz.listservice.presentation.json.ValidationJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/list")
public class ListResource {
	
	@Autowired
	private ListService listService;
	
	@RequestMapping(method=RequestMethod.GET)
    public java.util.List<ListJson> findAll() {
		
		return ListJsonFactory.create(this.listService.findAll());
    }
	
	@RequestMapping(method=RequestMethod.POST)
    public ListJson save(@RequestBody(required=true) ListJson listJson) {
		
		List list = ListJsonFactory.create(listJson);
		list = this.listService.save(list);
		return ListJsonFactory.create(list);
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/{listName}/item/{itemValue}")
    public ValidationJson isValid(@PathVariable String listName, @PathVariable String itemValue) throws ListServiceException {
		
		List list = this.listService.findByNameMandatory(listName);
		Boolean isValid = this.listService.isValid(list, itemValue);

		return ValidationJsonFactory.create(list, itemValue, isValid);
    }
	
}