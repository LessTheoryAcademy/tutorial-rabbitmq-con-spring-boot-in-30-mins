package com.lta.springrabbitmq.commons.message;

import java.io.Serializable;
import java.util.List;

public class OrderMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String customerName;
	private String customerAddress;
	private List<Integer> productsIds;
	private String notes;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public List<Integer> getProductsIds() {
		return productsIds;
	}
	public void setProductsIds(List<Integer> productsIds) {
		this.productsIds = productsIds;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
