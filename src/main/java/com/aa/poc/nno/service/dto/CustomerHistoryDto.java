/**
 * 
 */
package com.aa.poc.nno.service.dto;

import java.sql.Timestamp;

import com.aa.poc.nno.entity.Customer;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 842018
 *
 */

@Getter
@Setter
public class CustomerHistoryDto {

	private Customer customer;
	
	private long historyId;
	
	private double amount;
	
	private String transactionType;
	
	private String comment;
	
	private Timestamp lastUpdated;
	
	private long userId;

	@Override
	public String toString() {
		return "CustomerHistoryDto [customer=" + customer + ", historyId=" + historyId + ", amount=" + amount
				+ ", transactionType=" + transactionType + ", comment=" + comment + ", lastUpdated=" + lastUpdated
				+ ", userId=" + userId + "]";
	}
	
	
}
