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
public class BalanceDaoResponse {
	private String respCode;
	private String respMsg;
	private String balanceAmount;
	private String cardLimitAmount;
	private String unBilledAmount;

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public String getBalanceAmount() {
		return balanceAmount;
	}

	public void setBalanceAmount(String balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public String getCardLimitAmount() {
		return cardLimitAmount;
	}

	public void setCardLimitAmount(String cardLimitAmount) {
		this.cardLimitAmount = cardLimitAmount;
	}

	public String getUnBilledAmount() {
		return unBilledAmount;
	}

	public void setUnBilledAmount(String unBilledAmount) {
		this.unBilledAmount = unBilledAmount;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("BalanceDaoResponse [respCode=");
		buffer.append(respCode);
		buffer.append(", respMsg=");
		buffer.append(respMsg);
		buffer.append(", balanceAmount=");
		buffer.append(balanceAmount);
		buffer.append(", cardLimitAmount=");
		buffer.append(cardLimitAmount);
		buffer.append(", unBilledAmount=");
		buffer.append(unBilledAmount);
		buffer.append("]");
		return buffer.toString();
	}

}
