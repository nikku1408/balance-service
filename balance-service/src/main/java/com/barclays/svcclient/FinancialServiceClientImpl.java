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

package com.barclays.svcclient;

import org.springframework.stereotype.Component;

import com.barclays.model.FinanceRequest;
import com.barclays.model.FinanceResponse;

/**
 * @author : bunty
 * @date : Jun 27, 2022
 * 
 */
@Component
public class FinancialServiceClientImpl implements FinancialServiceClient {

	public FinanceResponse getRegionDetails(FinanceRequest financeRequest) {
		// TODO: Invoke the finance service to get the type of card
		FinanceResponse financeResponse = new FinanceResponse();
		financeResponse.setResponseCode("0");
		financeResponse.setResponseMsg("Success");
		financeResponse.setCardType("Domestic");
		return financeResponse;
	}

}
