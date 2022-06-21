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
	private String cardLimitAmount;
	private String unBilledAmount;
	private String creationDate;
	private String updateDate;
	private String availableBalance;

	public String getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(String availableBalance) {
		this.availableBalance = availableBalance;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

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

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("BalanceDaoResponse [respCode=");
		builder.append(respCode);
		builder.append(", respMsg=");
		builder.append(respMsg);
		builder.append(", cardLimitAmount=");
		builder.append(cardLimitAmount);
		builder.append(", unBilledAmount=");
		builder.append(unBilledAmount);
		builder.append(", creationDate=");
		builder.append(creationDate);
		builder.append(", updateDate=");
		builder.append(updateDate);
		builder.append(", availableBalance=");
		builder.append(availableBalance);
		builder.append("]");
		return builder.toString();
	}

}
