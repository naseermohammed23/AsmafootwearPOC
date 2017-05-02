/**
 * 
 */
package com.aa.poc.nno.service.dto;

import java.sql.Timestamp;

import com.aa.poc.nno.entity.Party;

/**
 * @author 842018
 *
 */
public class PartyHistoryDto {

	private Party party;
	
	private long historyId;
	
	private double amount;
	
	private String transactionType;
	
	private String comment;
	
	private Timestamp lastUpdated;
	
	private long userId;

	public Party getParty() {
		return party;
	}

	public void setParty(Party party) {
		this.party = party;
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
		return "PartyHistoryDto [party=" + party + ", historyId=" + historyId + ", amount=" + amount
				+ ", transactionType=" + transactionType + ", comment=" + comment + ", lastUpdated=" + lastUpdated
				+ ", userId=" + userId + "]";
	}
}
