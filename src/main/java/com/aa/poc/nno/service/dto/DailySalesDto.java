package com.aa.poc.nno.service.dto;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author 842018
 *
 */

@Getter
@Setter
public class DailySalesDto {
		private Long id;
		
		private Double salesAmount;
		
		private Double expenses;
		
		private Double profit;
		
		private Long userId;
		
		private Timestamp date;
}
