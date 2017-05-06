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
public class PartyDto {
	
    private Long id;
	
	private String partyName;
	
	private double balance;
	
	private String address;
	
	private long phoneNumber;
	
	private Timestamp lastUpdated;

	@Override
	public String toString() {
		return "PartyDto [id=" + id + ", partyName=" + partyName + ", balance=" + balance + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", lastUpdated=" + lastUpdated + "]";
	}

}
