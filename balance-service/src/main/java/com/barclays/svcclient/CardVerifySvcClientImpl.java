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

import org.springframework.stereotype.Component;

import com.barclays.model.CardVerifyRequest;
import com.barclays.model.CardVerifyResponse;

/**
 * @author : bunty
 * @date : Jun 13, 2022
 * 
 */
@Component
public class CardVerifySvcClientImpl implements CardVerifySvcClient {

	public CardVerifyResponse cardVerify(CardVerifyRequest cardVerifyRequest) {
		// TODO: Invoke or call card verify service to validate the card number
		return null;
	}

}
