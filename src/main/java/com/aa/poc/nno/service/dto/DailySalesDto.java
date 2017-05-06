package com.aa.poc.nno.service.dto;

import java.sql.Timestamp;

public class DailySalesDto {
		private Long id;
		
		private Double salesAmount;
		
		private Double expenses;
		
		private Double profit;
		
		private Long userId;
		
		private Timestamp date;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Double getSalesAmount() {
			return salesAmount;
		}

		public void setSalesAmount(Double salesAmount) {
			this.salesAmount = salesAmount;
		}

		public Double getExpenses() {
			return expenses;
		}

		public void setExpenses(Double expenses) {
			this.expenses = expenses;
		}

		public Double getProfit() {
			return profit;
		}

		public void setProfit(Double profit) {
			this.profit = profit;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public Timestamp getDate() {
			return date;
		}

		public void setDate(Timestamp date) {
			this.date = date;
		}

		
}
