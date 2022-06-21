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

package com.barclays.util;

/**
 * @author : bunty
 * @date : Jun 21, 2022
 * 
 */
public enum EnumBalanceErrorCodes {

	clientId_100("100", "clientId invalid", "data error"), cardNumber_101("101", "cardNumber invalid", "data error"),
	cvvNumber_102("102", "cvvNumber invalid", "data error"), expDate_103("103", "expDate invalid", "data error"),
	cardNum_WITH_cvv_104("104", "cardNum not mapped with cvv", "data error"),
	dbConnection_111("111", "unable to connect db", "system error"),
	syntax_222("222", "database syntax error", "system error"), databaseId_333("333", "database down", "system error");

	private String errorCode;
	private String errorMsg;
	private String typeOfError;

	EnumBalanceErrorCodes(String errorCode, String errorMsg, String typeOfError) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
		this.typeOfError = typeOfError;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public String getTypeOfError() {
		return typeOfError;
	}

	public static boolean checkErrorCodes(String dbRespCode, String errorType) {
		for (EnumBalanceErrorCodes e : EnumBalanceErrorCodes.values()) {
			if (dbRespCode.equals(e.getErrorCode()) && errorType.equals(e.getTypeOfError())) {
				return true;
			}
		}
		return false;
	}

}
