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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.exception.BusinessException;
import com.barclays.exception.SystemException;
import com.barclays.model.BalanceRequest;
import com.barclays.model.BalanceResponse;
import com.barclays.model.ClientDetails;
import com.barclays.model.CustomerDetails;
import com.barclays.model.DateRange;
import com.barclays.service.BalanceService;
import com.barclays.validator.BalanceRequestValidator;

/**
 * @author : bunty
 * @date : Jun 10, 2022
 * @Description: This method is used to get the list of balancedetails based on
 *               given balanceType, If the balanceType is billed then billed
 *               transaction will come else unbilled transaction will come.
 */
@RestController
@RequestMapping("/v1")
public class BalanceInfoController {
	@Autowired
	private BalanceRequestValidator balanceRequestValidator;
	@Autowired
	private BalanceService balanceService;

	/*
	 * Method parameters are nothing but the balancerequest client and customer
	 * details
	 * 
	 * Nonfunctional data is coming from headers(requestparam) and functional data
	 * is coming from pathvariable
	 */
	@RequestMapping(path = "/balance/{cardNum}/{cvv}/{nameOnCard}/{expDate}", method = RequestMethod.GET, produces = "application/json")
	public BalanceResponse getBalance(@PathVariable("cardNum") String cardNum,
			@PathVariable("nameOnCard") String nameOnCard, @PathVariable("expDate") String expDate,
			@PathVariable("cvv") String cvv, @RequestParam("balType") String balType,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("clientId") String clientId, @RequestParam("requestId") String requestId,
			@RequestParam("version") String version, @RequestParam("messageTimestamp") String messageTimestamp)
			throws BusinessException, SystemException {

		// Gather the input params into the balance request object
		BalanceRequest balanceRequest = new BalanceRequest();

		CustomerDetails customerDetails = new CustomerDetails();
		customerDetails.setCardNum(cardNum);
		customerDetails.setCvvNum(cvv);
		customerDetails.setNameOnCard(nameOnCard);
		customerDetails.setExpDate(expDate);

		DateRange dateRange = new DateRange();
		dateRange.setStartDate(startDate);
		dateRange.setEndDate(endDate);

		balanceRequest.setCustomerDetails(customerDetails);

		ClientDetails clientDetails = new ClientDetails();
		clientDetails.setClientId(clientId);
		clientDetails.setRequestId(requestId);
		clientDetails.setVersionNo(version);
		clientDetails.setMessageTs(messageTimestamp);

		balanceRequest.setClientDetails(clientDetails);

		// validate the request
		balanceRequestValidator.validateRequest(balanceRequest);

		// prepare the request for service class and call service
		BalanceResponse balanceResponse = balanceService.getBalance(balanceRequest);

		return balanceResponse;
	}
}
