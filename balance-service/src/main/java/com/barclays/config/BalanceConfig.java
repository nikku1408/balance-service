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

package com.barclays.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author : bunty
 * @date : Jun 10, 2022
 * 
 */
@Configuration
@ComponentScan(basePackages = "com.barclays.dao")
public class BalanceConfig {

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
		driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/gar?useSSL=false");
		driverManagerDataSource.setUsername("root");
		driverManagerDataSource.setPassword("Acerfaraari@123");
		return driverManagerDataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DriverManagerDataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

}
