package com.sankar.injectingvalidator.helpers;

import java.util.List;

public class Person {
	
	private String name;
	private String ssn;
	private List<String> alternateNames;
	private Address address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<String> getAlternateNames() {
		return alternateNames;
	}

	public void setAlternateNames(List<String> alternateNames) {
		this.alternateNames = alternateNames;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}