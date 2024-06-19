package com.eazybutes.eazybytes.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "card_id")
	private Integer cardId;

	@Column(name = "customer_id")
	private Integer customerId;

	@Column(name = "card_number")
	private String cardNumber;

	@Column(name = "card_type")
	private String cardType;

	@Column(name = "total_limit")
	private Integer totalLimit;

	@Column(name = "amount_used")
	private Integer amountUsed;

	@Column(name = "avaliable_amount")
	private Integer avaliableAmount;

	@Column(name = "create_dt")
	private Date credateDt;

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Integer getTotalLimit() {
		return totalLimit;
	}

	public void setTotalLimit(Integer totalLimit) {
		this.totalLimit = totalLimit;
	}

	public Integer getAmountUsed() {
		return amountUsed;
	}

	public void setAmountUsed(Integer amountUsed) {
		this.amountUsed = amountUsed;
	}

	public Integer getAvaliableAmount() {
		return avaliableAmount;
	}

	public void setAvaliableAmount(Integer avaliableAmount) {
		this.avaliableAmount = avaliableAmount;
	}

	public Date getCredateDt() {
		return credateDt;
	}

	public void setCredateDt(Date credateDt) {
		this.credateDt = credateDt;
	}

}
