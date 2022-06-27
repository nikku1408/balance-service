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

import com.barclays.model.FinanceRequest;
import com.barclays.model.FinanceResponse;

/**
 * @author : bunty
 * @date : Jun 27, 2022
 * 
 */
public interface FinancialServiceClient {
	public FinanceResponse getRegionDetails(FinanceRequest financeRequest);
}
