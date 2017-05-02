/**
 * 
 */
package com.aa.poc.nno.service.dto;

import java.sql.Timestamp;

/**
 * @author 842018
 *
 */
public class PartyDto {
	
    private Long id;
	
	private String partyName;
	
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

	public String getPartyName() {
		return partyName;
	}

	public void setPartyName(String partyName) {
		this.partyName = partyName;
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
		return "PartyDto [id=" + id + ", partyName=" + partyName + ", balance=" + balance + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", lastUpdated=" + lastUpdated + "]";
	}

}
