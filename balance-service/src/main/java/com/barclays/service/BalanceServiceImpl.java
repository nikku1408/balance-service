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
import com.barclays.svcclient.CardVerifySvcClient;

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

	public BalanceResponse getBalance(BalanceRequest balanceRequest) throws BusinessException, SystemException {
		/*
		 * Get the request from the controller
		 * 
		 * Identify the card number whether domestic or international use FinanceService
		 * 
		 * Call the card to verify service to validate the card number i.e if the card
		 * number is active or blocked or card number mapped with cvv
		 * 
		 * Based on card type it will route the request to the domestic or international
		 * backend
		 * 
		 * Get the response from backend systems and send data to the client or
		 * consumer.
		 */
		return null;
	}

}
