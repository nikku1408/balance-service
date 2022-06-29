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

import org.springframework.stereotype.Component;

import com.barclays.model.BalanceRequest;

/**
 * @author : bunty
 * @date : Jun 10, 2022
 * 
 */
@Component
public class BalanceRequestValidator {
	public void validateRequest(BalanceRequest balanceRequest) throws BalanceRequestInvalidException {
		// TODO: Validations?
		if (balanceRequest == null || balanceRequest.getClientDetails() == null
				|| balanceRequest.getCustomerDetails() == null) {
			throw new BalanceRequestInvalidException("bal001", "request object null!..");
		}

		String cardNumber = balanceRequest.getCustomerDetails().getCardNum();
		if (cardNumber == null || " ".equals(cardNumber) || cardNumber.length() != 15) {
			throw new BalanceRequestInvalidException("bal002", "client id is invalid!..");
		}

		String cvvNumber = balanceRequest.getCustomerDetails().getCvvNum();
		if (cvvNumber == null || " ".equals(cvvNumber) || cvvNumber.length() != 15) {
			throw new BalanceRequestInvalidException("bal003", "cvv is invalid!..");
		}

		// TODO: need to write validations all the mandatory elements
	}
}
