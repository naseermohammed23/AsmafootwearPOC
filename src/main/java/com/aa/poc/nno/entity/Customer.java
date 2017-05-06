package com.aa.poc.nno.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author 842018
 *
 */

@Entity
@Table(name="CUSTOMER")
@Getter
@Setter
public class Customer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="customer_balance")
	private double balance;
	
	@Column(name="address")
	private String address;
	
	@Column(name="phone_no")
	private long phoneNumber;
	
	@Column(name="last_updated")
	private Timestamp lastUpdated;

	@Override
	public String toString() {
		return "Customer [id=" + id + ", custmerName=" + customerName
				+ ", balance=" + balance + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", lastUpdated="
				+ lastUpdated + "]";
	}
	
}
