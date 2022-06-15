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

package com.barclays.dao;

import org.springframework.stereotype.Component;

import com.barclays.model.BalanceDaoRequest;
import com.barclays.model.BalanceDaoResponse;

/**
 * @author : bunty
 * @date : Jun 10, 2022
 * 
 */
@Component
public interface BalanceInfoDao {
	BalanceDaoResponse getBalance(BalanceDaoRequest balanceDaoRequest);
}
