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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

import com.barclays.config.BalanceConfig;
import com.barclays.exception.BusinessException;
import com.barclays.exception.SystemException;
import com.barclays.model.BalanceDaoRequest;
import com.barclays.model.BalanceDaoResponse;

/**
 * @author : bunty
 * @date : Jun 10, 2022
 * 
 */
@Component
public class BalanceInfoDomasticDaoSpringJdbcTemplatePoc extends StoredProcedure
		implements BalanceInfoDao, RowMapper<BalanceDaoResponse> {

	@Autowired
	public BalanceInfoDomasticDaoSpringJdbcTemplatePoc(JdbcTemplate jdbcTemplate) {
		/* register stored procedure with JdbcTemplate */
		super(jdbcTemplate, "GET_BALANCE");
		registerParams();
	}

	public void registerParams() {

		/* register input params */
		declareParameter(new SqlParameter("client_id_in", Types.VARCHAR));
		declareParameter(new SqlParameter("card_number_in", Types.VARCHAR));
		declareParameter(new SqlParameter("cvv_num_in", Types.VARCHAR));
		declareParameter(new SqlParameter("exp_date_in", Types.VARCHAR));

		/* register output params */
		declareParameter(new SqlOutParameter("response_code_out", Types.VARCHAR));
		declareParameter(new SqlOutParameter("response_msg_out", Types.VARCHAR));

		/* register resultset */
		declareParameter(new SqlReturnResultSet("balanceResult", this));
		compile();
	}

	public BalanceDaoResponse getBalance(BalanceDaoRequest balanceDaoRequest)
			throws BusinessException, SystemException {

		List<BalanceDaoResponse> daoResp = new ArrayList<BalanceDaoResponse>();

		/* Prepare stored procedure request */
		try {
			Map<String, Object> reqMap = new HashMap<String, Object>();
			reqMap.put("client_id_in", balanceDaoRequest.getClientId());
			reqMap.put("card_number_in", balanceDaoRequest.getCardNum());
			reqMap.put("cvv_num_in", balanceDaoRequest.getCvvNum());
			reqMap.put("exp_date_in", balanceDaoRequest.getExpDate());

			/* calling stored procedure */
			Map<String, Object> resMap = super.execute(reqMap);

			/* get the stored procedure out param values */
			String dbRespCode = resMap.get("response_code_out").toString();
			String dbRespMsg = resMap.get("response_msg_out").toString();

			if ("200".equals(dbRespCode)) {
				daoResp = (List<BalanceDaoResponse>) resMap.get("balanceResult");
				daoResp.get(0).setRespCode(dbRespCode);
				daoResp.get(0).setRespMsg(dbRespMsg);
			} else if ("100".equals(dbRespCode) || "101".equals(dbRespCode) || "102".equals(dbRespCode)
					|| "103".equals(dbRespCode)) {
				throw new BusinessException(dbRespCode, dbRespMsg);
			} else if ("111".equals(dbRespCode) || "222".equals(dbRespCode) || "333".equals(dbRespCode)) {
				throw new SystemException(dbRespCode, dbRespMsg);
			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		} catch (BusinessException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return daoResp.get(0);
	}

	/* handling result set and convert resultset into dao response */
	public BalanceDaoResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		BalanceDaoResponse balanceDaoResponse = new BalanceDaoResponse();
		balanceDaoResponse.setCardLimitAmount(rs.getString("credit_limit"));
		balanceDaoResponse.setAvailableBalance(rs.getString("available_balance"));
		balanceDaoResponse.setUnBilledAmount(rs.getString("unbilled_amount"));
		balanceDaoResponse.setCreationDate(rs.getString("creation_date"));
		balanceDaoResponse.setUpdateDate(rs.getString("updated_date"));
		return balanceDaoResponse;
	}

	public static void main(String[] args) throws BusinessException, SystemException {
		ApplicationContext context = new AnnotationConfigApplicationContext(BalanceConfig.class);
		BalanceInfoDomasticDaoSpringJdbcTemplatePoc balanceInfoDomasticDaoSpringJdbc = context
				.getBean(BalanceInfoDomasticDaoSpringJdbcTemplatePoc.class);
		BalanceDaoRequest balanceDaoRequest = new BalanceDaoRequest();
		balanceDaoRequest.setCardNum("11401503405222");
		balanceDaoRequest.setClientId("12345");
		balanceDaoRequest.setCvvNum("123");
		balanceDaoRequest.setExpDate("12-2022");

		BalanceDaoResponse balanceDaoResponse = balanceInfoDomasticDaoSpringJdbc.getBalance(balanceDaoRequest);
		System.out.println(balanceDaoResponse);
	}
	/*
	 * In Configuration class
	 * 
	 * Annotation over class
	 * 
	 * @Configuration *
	 * 
	 * @ComponentScan(basePackages = "com.barclays.dao")
	 * 
	 * @Bean public DriverManagerDataSource dataSource() { DriverManagerDataSource
	 * driverManagerDataSource = new DriverManagerDataSource();
	 * driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	 * driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/gar?useSSL=false"
	 * ); driverManagerDataSource.setUsername("root");
	 * driverManagerDataSource.setPassword("Acerfaraari@123"); return
	 * driverManagerDataSource; }
	 * 
	 * @Bean public JdbcTemplate jdbcTemplate(DriverManagerDataSource dataSource) {
	 * return new JdbcTemplate(dataSource); }
	 */

}
