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
public class BalanceResponse {
	private StatusBlock statusBlock;
	private BalanceInfo balanceInfo;

	public StatusBlock getStatusBlock() {
		return statusBlock;
	}

	public void setStatusBlock(StatusBlock statusBlock) {
		this.statusBlock = statusBlock;
	}

	public BalanceInfo getBalanceInfo() {
		return balanceInfo;
	}

	public void setBalanceInfo(BalanceInfo balanceInfo) {
		this.balanceInfo = balanceInfo;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("BalanceResponse []");
		return buffer.toString();
	}

}
