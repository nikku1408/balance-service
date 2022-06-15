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
 * @date : Jun 10, 2022
 * 
 */
@Component
public class BalanceDaoRequest {
	private String clientId;
	private String requestId;
	private String cardNum;
	private String cvvNum;
	private String nameOnCard;
	private String expDate;
	private String txnType;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

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

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("BalanceDaoRequest [clientId=");
		buffer.append(clientId);
		buffer.append(", requestId=");
		buffer.append(requestId);
		buffer.append(", cardNum=");
		buffer.append(cardNum);
		buffer.append(", cvvNum=");
		buffer.append(cvvNum);
		buffer.append(", nameOnCard=");
		buffer.append(nameOnCard);
		buffer.append(", expDate=");
		buffer.append(expDate);
		buffer.append(", txnType=");
		buffer.append(txnType);
		buffer.append("]");
		return buffer.toString();
	}

}
