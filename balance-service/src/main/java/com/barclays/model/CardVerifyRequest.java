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
 * @date : Jun 13, 2022
 * 
 */
@Component
public class CardVerifyRequest {
	private String cardNum;
	private String cvvNum;
	private String nameOnCard;

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCvvNum() {
		return cvvNum;
	}

	public void setCvvNum(String cvvNum) {
		this.cvvNum = cvvNum;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("CardVerifyRequest [cardNum=");
		buffer.append(cardNum);
		buffer.append(", cvvNum=");
		buffer.append(cvvNum);
		buffer.append(", nameOnCard=");
		buffer.append(nameOnCard);
		buffer.append("]");
		return buffer.toString();
	}

}
