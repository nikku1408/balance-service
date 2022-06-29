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

package com.barclays.validator;

/**
 * @author : bunty
 * @date : Jun 28, 2022
 * 
 */
public class BalanceRequestInvalidException extends RuntimeException {
	private String responseCode;
	private String responseMessage;

	public BalanceRequestInvalidException(String responseCode, String responseMessage) {
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BalanceRequestInvalidException [responseCode=");
		builder.append(responseCode);
		builder.append(", responseMessage=");
		builder.append(responseMessage);
		builder.append("]");
		return builder.toString();
	}

}
