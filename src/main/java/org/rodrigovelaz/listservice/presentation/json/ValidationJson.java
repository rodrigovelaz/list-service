package org.rodrigovelaz.listservice.presentation.json;

public class ValidationJson {

	private ListJson list;
	private String item;
	private Boolean isValid;

	public ListJson getList() {
		return list;
	}
	public void setList(ListJson list) {
		this.list = list;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

}
