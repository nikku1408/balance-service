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

import org.springframework.stereotype.Component;

/**
 * @author : bunty
 * @date : Jun 13, 2022
 * 
 */
@Component
public class BalanceInfo {
	private String balanceAmt;
	private String availableAmt;
	private String unbilledAmt;
	private String cardNum;
	private String cvvNum;
	private String nameOnCard;
	private String expDate;

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

	public String getBalanceAmt() {
		return balanceAmt;
	}

	public void setBalanceAmt(String balanceAmt) {
		this.balanceAmt = balanceAmt;
	}

	public String getAvailableAmt() {
		return availableAmt;
	}

	public void setAvailableAmt(String availableAmt) {
		this.availableAmt = availableAmt;
	}

	public String getUnbilledAmt() {
		return unbilledAmt;
	}

	public void setUnbilledAmt(String unbilledAmt) {
		this.unbilledAmt = unbilledAmt;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("BalanceInfo [balanceAmt=");
		buffer.append(balanceAmt);
		buffer.append(", availableAmt=");
		buffer.append(availableAmt);
		buffer.append(", unbilledAmt=");
		buffer.append(unbilledAmt);
		buffer.append(", cardNum=");
		buffer.append(cardNum);
		buffer.append(", cvvNum=");
		buffer.append(cvvNum);
		buffer.append(", nameOnCard=");
		buffer.append(nameOnCard);
		buffer.append(", expDate=");
		buffer.append(expDate);
		buffer.append("]");
		return buffer.toString();
	}

}
