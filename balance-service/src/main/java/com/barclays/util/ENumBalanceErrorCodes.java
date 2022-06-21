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
public enum ENumBalanceErrorCodes {
	clientId_100("100", "clientId invalid", "data error"), clientId_101("101", "clientId invalid", "data error"),
	clientId_102("102", "clientId invalid", "data error"), clientId_103("103", "clientId invalid", "data error"),
	clientId_104("104", "clientId invalid", "data error"), clientId_111("111", "clientId invalid", "system error"),
	clientId_222("222", "clientId invalid", "system error"), clientId_333("333", "clientId invalid", "system error");

	private String errorCode;
	private String errorMsg;
	private String typeOfError;

	ENumBalanceErrorCodes(String errorCode, String errorMsg, String typeOfError) {
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
		for (ENumBalanceErrorCodes e : ENumBalanceErrorCodes.values()) {
			if (dbRespCode.equals(e.getErrorCode()) && errorType.equals(e.getTypeOfError())) {
				return true;
			}
		}
		return false;
	}
}
