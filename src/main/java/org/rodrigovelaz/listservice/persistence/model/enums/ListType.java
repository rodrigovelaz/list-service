package org.rodrigovelaz.listservice.persistence.model.enums;

public enum ListType {

	BLACKLIST("BLACKLIST"),
	WHITELIST("WHITELIST"),
	REGULAR_EXPRESSION("REGULAR_EXPRESSION");
	
	private String value;
	
    private ListType(String value) {
    	this.value = value;
    }

    @Override
    public String toString() {
    	return this.value;
    }
}