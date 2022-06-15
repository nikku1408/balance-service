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

/**
 * @author : bunty
 * @date : Jun 13, 2022
 * 
 */
public class ClientDetails {
	private String clientId;
	private String channelId;
	private String requestId;
	private String versionNo;
	private String messageTs;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getVersionNo() {
		return versionNo;
	}

	public void setVersionNo(String versionNo) {
		this.versionNo = versionNo;
	}

	public String getMessageTs() {
		return messageTs;
	}

	public void setMessageTs(String messageTs) {
		this.messageTs = messageTs;
	}

	/*
	 * alt+shift+r for group editing. select the variable then press then edit along
	 * with remaining same variable
	 */
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("ClientDetails [clientId=");
		buffer.append(clientId);
		buffer.append(", channelId=");
		buffer.append(channelId);
		buffer.append(", requestId=");
		buffer.append(requestId);
		buffer.append(", versionNo=");
		buffer.append(versionNo);
		buffer.append(", messageTs=");
		buffer.append(messageTs);
		buffer.append("]");
		return buffer.toString();
	}

}
