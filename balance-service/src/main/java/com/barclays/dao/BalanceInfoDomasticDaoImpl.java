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

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.stereotype.Component;

import com.barclays.model.BalanceDaoRequest;
import com.barclays.model.BalanceDaoResponse;

/**
 * @author : bunty
 * @date : Jun 10, 2022
 * 
 */
@Component
public class BalanceInfoDomasticDaoImpl implements BalanceInfoDao {

	public BalanceDaoResponse getBalance(BalanceDaoRequest balanceDaoRequest) {

		BalanceDaoResponse daoResp = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/gar?useSSL=false";
			String username = "root";
			String password = "Acerfaraari@123";
			String query = "{call gar.GET_BALANCE(?,?,?,?,?,?)}";
			Connection con = DriverManager.getConnection(url, username, password);
			CallableStatement callableStatement = con.prepareCall(query);

			/* input params */
			callableStatement.setString(1, balanceDaoRequest.getClientId());
			callableStatement.setString(2, balanceDaoRequest.getCardNum());
			callableStatement.setString(3, balanceDaoRequest.getCvvNum());
			callableStatement.setString(4, balanceDaoRequest.getExpDate());

			/* Output params */
			callableStatement.registerOutParameter(5, Types.VARCHAR);
			callableStatement.registerOutParameter(6, Types.VARCHAR);

			/* Execution */
			callableStatement.execute();

			/* getting the output params data */
			String dbRespCode = callableStatement.getString(5);
			String dbRespMsg = callableStatement.getString(6);
			System.out.println(dbRespCode + " " + dbRespMsg);

			ResultSet rs = callableStatement.executeQuery();

			daoResp = new BalanceDaoResponse();
			if (dbRespCode != null && dbRespMsg != null && "200".equals(dbRespCode)) {
				daoResp.setRespCode(dbRespCode);
				daoResp.setRespMsg(dbRespMsg);
				while (rs.next()) {
					daoResp.setCardLimitAmount(rs.getString("credit_limit"));
					daoResp.setUnBilledAmount(rs.getString("unbilled_amount"));
					daoResp.setAvailableBalance(rs.getString("available_balance"));
					daoResp.setCreationDate(rs.getString("creation_date"));
					daoResp.setUpdateDate("updated_date");
				}
			} else if ("100".equals(dbRespCode) || "101".equals(dbRespCode) || "102".equals(dbRespCode)
					|| "103".equals(dbRespCode)) {
				// Todo: throw user defined exception as Business exception

			} else {
				// Todo: throw user defined exception as System exception
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return daoResp;
	}

	public static void main(String[] args) {
		BalanceInfoDao balanceInfoDao = new BalanceInfoDomasticDaoImpl();
		BalanceDaoRequest balanceDaoRequest = new BalanceDaoRequest();
		balanceDaoRequest.setCardNum("11401503405222");
		balanceDaoRequest.setClientId("12345");
		balanceDaoRequest.setCvvNum("123");
		balanceDaoRequest.setExpDate("12-2022");
		balanceDaoRequest.setNameOnCard("ansh");
		balanceDaoRequest.setRequestId("r-001");
		BalanceDaoResponse balanceDaoResponse = balanceInfoDao.getBalance(balanceDaoRequest);
		System.out.println("BalanceDaoResponse: " + balanceDaoResponse);
	}

}
