package edu.hccs.myspring;

import org.springframework.stereotype.Component;

@Component
public class Publisher {
	private String name;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Publisher [name=" + name + ", address=" + address + "]";
	}
	
	
}
