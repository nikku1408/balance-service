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

package com.barclays.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.model.BalanceRequest;
import com.barclays.model.BalanceResponse;
import com.barclays.service.BalanceService;
import com.barclays.validator.BalanceRequestValidator;

/**
 * @author : bunty
 * @date : Jun 10, 2022
 * 
 */
@RestController
@RequestMapping("/v1")
public class BalanceInfoController {
	@Autowired
	private BalanceRequestValidator balanceRequestValidator;
	@Autowired
	private BalanceService balanceService;

	@RequestMapping(path = "/balance", method = RequestMethod.GET, produces = "application/json")
	public BalanceResponse getBalance(BalanceRequest balanceRequest) {

		// validate the request
		balanceRequestValidator.validateRequest(balanceRequest);

		// prepare the request for service class and call service
		BalanceResponse balanceResponse = balanceService.getBalance(balanceRequest);

		return null;
	}
}
