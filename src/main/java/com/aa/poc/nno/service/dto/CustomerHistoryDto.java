/**
 * 
 */
package com.aa.poc.nno.service.dto;

import java.sql.Timestamp;

import com.aa.poc.nno.entity.Customer;

/**
 * @author 842018
 *
 */
public class CustomerHistoryDto {

	private Customer customer;
	
	private long historyId;
	
	private double amount;
	
	private String transactionType;
	
	private String comment;
	
	private Timestamp lastUpdated;
	
	private long userId;

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(long historyId) {
		this.historyId = historyId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Timestamp getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Timestamp lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "CustomerHistoryDto [customer=" + customer + ", historyId=" + historyId + ", amount=" + amount
				+ ", transactionType=" + transactionType + ", comment=" + comment + ", lastUpdated=" + lastUpdated
				+ ", userId=" + userId + "]";
	}
	
	
}
