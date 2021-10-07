package com.model;

import javax.validation.constraints.Min;

import org.springframework.stereotype.Component;

@Component
public class Item {
	
	private String itemName;
	@Min(value=1, message="Quantity should be minimum 1 Kg")
	private int quantity;
	private double ratePerKg;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getRatePerKg() {
		return ratePerKg;
	}
	public void setRatePerKg(double ratePerKg) {
		this.ratePerKg = ratePerKg;
	}
	

}
