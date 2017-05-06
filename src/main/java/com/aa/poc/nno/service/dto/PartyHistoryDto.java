/**
 * 
 */
package com.aa.poc.nno.service.dto;

import java.sql.Timestamp;

import com.aa.poc.nno.entity.Party;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 842018
 *
 */

@Getter
@Setter
public class PartyHistoryDto {

	private Party party;
	
	private long historyId;
	
	private double amount;
	
	private String transactionType;
	
	private String comment;
	
	private Timestamp lastUpdated;
	
	private long userId;

	@Override
	public String toString() {
		return "PartyHistoryDto [party=" + party + ", historyId=" + historyId + ", amount=" + amount
				+ ", transactionType=" + transactionType + ", comment=" + comment + ", lastUpdated=" + lastUpdated
				+ ", userId=" + userId + "]";
	}
}
