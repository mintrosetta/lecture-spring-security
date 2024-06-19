package com.eazybutes.eazybytes.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loans")
public class Loan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "loan_number")
	private Integer loadNumber;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "start_dt")
	private Date startDt;

	@Column(name = "loan_type")
	private String loanType;

	@Column(name = "total_loan")
	private Integer totalLoan;

	@Column(name = "amount_paid")
	private Integer amountPaid;

	@Column(name = "outstanding_amount")
	private Integer outstandingAmount;

	@Column(name = "create_dt")
	private String createDt;

	public Integer getLoadNumber() {
		return loadNumber;
	}

	public void setLoadNumber(Integer loadNumber) {
		this.loadNumber = loadNumber;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Date getStartDt() {
		return startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public Integer getTotalLoan() {
		return totalLoan;
	}

	public void setTotalLoan(Integer totalLoan) {
		this.totalLoan = totalLoan;
	}

	public Integer getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(Integer amountPaid) {
		this.amountPaid = amountPaid;
	}

	public Integer getOutstandingAmount() {
		return outstandingAmount;
	}

	public void setOutstandingAmount(Integer outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public String getCreateDt() {
		return createDt;
	}

	public void setCreateDt(String createDt) {
		this.createDt = createDt;
	}

}
