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

package com.barclays.controller.advice;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.barclays.exception.BusinessException;
import com.barclays.exception.SystemException;
import com.barclays.model.BalanceResponse;
import com.barclays.model.StatusBlock;
import com.barclays.validator.BalanceRequestInvalidException;

/**
 * @author : bunty
 * @date : Jun 10, 2022
 * 
 */
@ControllerAdvice
public class BalanceControllerAdvice {

	@ExceptionHandler(value = BalanceRequestInvalidException.class)
	public BalanceResponse handleRequestInvalidException(
			BalanceRequestInvalidException balanceRequestInvalidException) {
		balanceRequestInvalidException.printStackTrace();
		return handleErrorResponse(balanceRequestInvalidException.getResponseCode(),
				balanceRequestInvalidException.getResponseMessage());
	}

	@ExceptionHandler(value = BusinessException.class)
	public BalanceResponse handleRequestInvalidException(BusinessException businessException) {
		businessException.printStackTrace();
		return handleErrorResponse(businessException.getErrorCode(), businessException.getErrorMsg());
	}

	@ExceptionHandler(value = SystemException.class)
	public BalanceResponse handleRequestInvalidException(SystemException systemException) {
		systemException.printStackTrace();
		return handleErrorResponse(systemException.getErrorCode(), systemException.getErrorMsg());
	}

	@ExceptionHandler(value = Exception.class)
	public BalanceResponse handleGenericException(Exception exception) {
		exception.printStackTrace();
		return handleErrorResponse("8888", "GENERIC ERROR MESSAGE: " + exception.getMessage());
	}

	/* Refactored method */
	private BalanceResponse handleErrorResponse(String respCode, String respMsg) {
		BalanceResponse balanceResponse = new BalanceResponse();

		StatusBlock statusBlock = new StatusBlock();
		statusBlock.setRespCode(respCode);
		statusBlock.setRespMsg(respMsg);

		balanceResponse.setStatusBlock(statusBlock);
		return balanceResponse;
	}
}
