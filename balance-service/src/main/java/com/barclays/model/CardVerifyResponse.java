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
public class CardVerifyResponse {
	private String status;
	private String typeOfCard;
	private String responseCode;
	private String responseMsg;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTypeOfCard() {
		return typeOfCard;
	}

	public void setTypeOfCard(String typeOfCard) {
		this.typeOfCard = typeOfCard;
	}

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

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("CardVerifyResponse [status=");
		buffer.append(status);
		buffer.append(", typeOfCard=");
		buffer.append(typeOfCard);
		buffer.append(", responseCode=");
		buffer.append(responseCode);
		buffer.append(", responseMsg=");
		buffer.append(responseMsg);
		buffer.append("]");
		return buffer.toString();
	}
}
