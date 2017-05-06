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
@Table(name="SALESUMMARY")
@Getter
@Setter
public class SaleSummary {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="date")
	private Timestamp date;
	
	@Column(name="sale_amount")
	private double salesAmount;
	
	@Column(name="expenses")
	private double expenses;
	
	@Column(name="profit")
	private double profit;
	
	@Column(name="user_id")
	private long userId;
}
