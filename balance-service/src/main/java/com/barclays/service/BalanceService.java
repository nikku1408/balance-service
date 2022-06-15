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

import com.barclays.model.BalanceRequest;
import com.barclays.model.BalanceResponse;

/**
 * @author : bunty
 * @date : Jun 10, 2022
 * 
 */
public interface BalanceService {
	BalanceResponse getBalance(BalanceRequest balanceRequest);
}
