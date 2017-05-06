/**
 * 
 */
package com.aa.poc.nno.service.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * @author 842018
 *
 */
@Getter
@Setter
public class CustomerDto {

    private Long id;
	
	private String customerName;
	
	private double balance;
	
	private String address;
	
	private long phoneNumber;
	
	private Timestamp lastUpdated;

	@Override
	public String toString() {
		return "CustomerDto [id=" + id + ", custmerName=" + customerName + ", balance=" + balance + ", address="
				+ address + ", phoneNumber=" + phoneNumber + ", lastUpdated=" + lastUpdated + "]";
	}
	
}
