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

package com.barclays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.barclays.dao.BalanceInfoDao;
import com.barclays.exception.BusinessException;
import com.barclays.exception.SystemException;
import com.barclays.model.BalanceRequest;
import com.barclays.model.BalanceResponse;
import com.barclays.model.CardVerifyRequest;
import com.barclays.model.CardVerifyResponse;
import com.barclays.model.FinanceRequest;
import com.barclays.model.FinanceResponse;
import com.barclays.svcclient.CardVerifySvcClient;
import com.barclays.svcclient.FinancialServiceClient;

/**
 * @author : bunty
 * @date : Jun 10, 2022
 * 
 */
@Component
public class BalanceServiceImpl implements BalanceService {

	@Autowired
	@Qualifier("balanceInfoDomasticDaoImpl")
	private BalanceInfoDao domesticDao;
	@Autowired
	@Qualifier("balanceInfoInternationslDaoImpl")
	private BalanceInfoDao internationalDao;
	@Autowired
	private CardVerifySvcClient cardVerifySvcClient;
	@Autowired
	private FinancialServiceClient financialServiceClient;

	public BalanceResponse getBalance(BalanceRequest balanceRequest) throws BusinessException, SystemException {

		// Get the request from the controller

		// Identify the card number whether domestic or international use FinanceService
		FinanceRequest financeRequest = new FinanceRequest();
		financeRequest.setCardNumber(balanceRequest.getCustomerDetails().getCardNum());
		financeRequest.setClientId(balanceRequest.getClientDetails().getClientId());
		financeRequest.setRequestId(balanceRequest.getClientDetails().getRequestId());

		FinanceResponse financeResponse = financialServiceClient.getRegionDetails(financeRequest);

		// Call the card to verify service to validate the card number i.e if the card
		// number is active or blocked or card number mapped with cvv
		CardVerifyRequest cardVerifyRequest = new CardVerifyRequest();
		cardVerifyRequest.setCardNum(balanceRequest.getCustomerDetails().getCardNum());
		cardVerifyRequest.setCvvNum(balanceRequest.getCustomerDetails().getCvvNum());
		cardVerifyRequest.setNameOnCard(balanceRequest.getCustomerDetails().getNameOnCard());

		CardVerifyResponse cardVerifyResponse = cardVerifySvcClient.cardVerify(cardVerifyRequest);

		// Based on card type it will route the request to the domestic or international
		// backend
		if ("0".equals(cardVerifyResponse.getResponseCode()) && "active".equals(cardVerifyResponse.getStatus())) {
			if ("domestic".equals(financeResponse.getCardType())) {

			}
		}

		// Get the response from backend systems and send data to the client or
		// consumer.

		return null;
	}

}
