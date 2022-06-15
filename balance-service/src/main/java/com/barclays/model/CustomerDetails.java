/**
 * @Author : bunty
 * Copyright (C) 2022 Bunty - All Rights Reserved
 * You may use, distribute and modify this code under the
 * terms of My license, which unfortunately won't be
 * written for another century.
 *
 * You should have received a copy of the My license with
 * this file. If not, please write to: nikhilninawe.in1@gmail.com.
 */

package com.barclays.model;

/**
 * @author : bunty
 * @date : Jun 13, 2022
 * 
 */
public class CustomerDetails {
	private String cardNum;
	private String cvvNum;
	private String nameOnCard;
	private String expDate;
	private String txnType;
	private DateRange dateRange;

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCvvNum() {
		return cvvNum;
	}

	public void setCvvNum(String cvvNum) {
		this.cvvNum = cvvNum;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public DateRange getDateRange() {
		return dateRange;
	}

	public void setDateRange(DateRange dateRange) {
		this.dateRange = dateRange;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("CustomerDetails [cardNum=");
		buffer.append(cardNum);
		buffer.append(", cvvNum=");
		buffer.append(cvvNum);
		buffer.append(", nameOnCard=");
		buffer.append(nameOnCard);
		buffer.append(", expDate=");
		buffer.append(expDate);
		buffer.append(", txnType=");
		buffer.append(txnType);
		buffer.append(", dateRange=");
		buffer.append(dateRange);
		buffer.append("]");
		return buffer.toString();
	}
}
