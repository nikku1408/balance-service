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

package com.barclays.model;

import org.springframework.stereotype.Component;

/**
 * @author : bunty
 * @date : Jun 10, 2022
 * 
 */
@Component
public class BalanceRequest {
	private ClientDetails clientDetails;
	private CustomerDetails customerDetails;

	public ClientDetails getClientDetails() {
		return clientDetails;
	}

	public void setClientDetails(ClientDetails clientDetails) {
		this.clientDetails = clientDetails;
	}

	public CustomerDetails getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(CustomerDetails customerDetails) {
		this.customerDetails = customerDetails;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("BalanceRequest [clientDetails=");
		buffer.append(clientDetails);
		buffer.append(", customerDetails=");
		buffer.append(customerDetails);
		buffer.append("]");
		return buffer.toString();
	}
}
