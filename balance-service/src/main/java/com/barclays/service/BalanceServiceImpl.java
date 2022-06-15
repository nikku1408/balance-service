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
import com.barclays.model.BalanceDaoRequest;
import com.barclays.model.BalanceDaoResponse;
import com.barclays.model.BalanceRequest;
import com.barclays.model.BalanceResponse;
import com.barclays.model.CardVerifyRequest;
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

	public BalanceResponse getBalance(BalanceRequest balanceRequest) {
		// get the request from controller

		// prepare the request for cardVerifyService

		CardVerifyRequest cardVerifyRequest = new CardVerifyRequest();
		// call card verify service
		cardVerifySvcClient.cardVerify(cardVerifyRequest);
		// identify card is domestic or international

		// if the card is domestic call domesticDao and vice versa

		//
		BalanceDaoRequest balanceDaoRequest = new BalanceDaoRequest();
		BalanceDaoResponse balanceDaoResponse = domesticDao.getBalance(balanceDaoRequest);
		BalanceDaoResponse balanceDaoResponse2 = internationalDao.getBalance(balanceDaoRequest);
		return null;
	}

}
