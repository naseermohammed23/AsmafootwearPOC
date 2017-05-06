package com.aa.poc.nno.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author 842018
 *
 */

@Entity
@Table(name="PARTYHISTORY")
@Getter
@Setter
public class PartyHistory {

	@ManyToOne
	private Party party;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long historyId;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="trans_type")
	private String transactionType;
	
	@Column(name="comment")
	private String comment;
	
	@Column(name="last_updated")
	private Timestamp lastUpdated;
	
	@Column(name="user_id")
	private long userId;
}
