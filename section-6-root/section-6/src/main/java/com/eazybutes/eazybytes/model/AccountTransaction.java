package com.eazybutes.eazybytes.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "account_transactions")
public class AccountTransaction {

	@Id
	@Column(name = "tracsaction_id")
	private String transactionId;
	
	@Column(name = "account_number")
	private Long accountNumber;
	
	@Column(name = "customer_id")
	private Integer customerId;
	
	@Column(name = "transaction_dt")
	private Date transactionDt;
	
	@Column(name = "transaction_summary")
	private String transactionSummary;
	
	@Column(name = "transaction_type")
	private String transactionType;
	
	@Column(name = "transaction_amt")
	private Integer transactionAmt;
	
	@Column(name = "closing_balance")
	private Integer closingBalance;
	
	@Column(name = "create_dt")
	private String createDt;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Date getTransactionDt() {
		return transactionDt;
	}

	public void setTransactionDt(Date transactionDt) {
		this.transactionDt = transactionDt;
	}

	public String getTransactionSummary() {
		return transactionSummary;
	}

	public void setTransactionSummary(String transactionSummary) {
		this.transactionSummary = transactionSummary;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Integer getTransactionAmt() {
		return transactionAmt;
	}

	public void setTransactionAmt(Integer transactionAmt) {
		this.transactionAmt = transactionAmt;
	}

	public Integer getClosingBalance() {
		return closingBalance;
	}

	public void setClosingBalance(Integer closingBalance) {
		this.closingBalance = closingBalance;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

}
