/**
 * 
 */
package com.aa.poc.nno.service.dto;

import java.sql.Timestamp;

/**
 * @author 842018
 *
 */
public class CustomerDto {

    private Long id;
	
	private String customerName;
	
	private double balance;
	
	private String address;
	
	private long phoneNumber;
	
	private Timestamp lastUpdated;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", custmerName=" + customerName + ", balance=" + balance + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", lastUpdated=" + lastUpdated + "]";
	}
	
}
