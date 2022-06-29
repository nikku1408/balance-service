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
 * @date : Jun 27, 2022
 * 
 * @Description: This service class will give the information of cardtype
 *               domestic/intl
 */
@Component
public class FinanceResponse {
	private String responseCode;
	private String responseMsg;
	private String cardType;
	private String cardNumber;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FinanceResponse [responseCode=");
		builder.append(responseCode);
		builder.append(", responseMsg=");
		builder.append(responseMsg);
		builder.append(", cardType=");
		builder.append(cardType);
		builder.append(", cardNumber=");
		builder.append(cardNumber);
		builder.append("]");
		return builder.toString();
	}

}
