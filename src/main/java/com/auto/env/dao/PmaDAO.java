package com.auto.env.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.auto.env.config.DBConfig;

@Component
public class PmaDAO {
	
	@Autowired
	DBConfig datasource;
	JdbcTemplate template;
	
	public void updateQuery(String environment) {
		template= new JdbcTemplate(datasource.getDataSource("pma"+environment));
		DBUtiliDAO dbUtiliDAO =new DBUtiliDAO(template,environment);
		dbUtiliDAO.updatePMADB();
	}
	
	public void updatePackageQuery(String environment) {
		template= new JdbcTemplate(datasource.getDataSource("pma"+environment));
		DBUtiliDAO dbUtiliDAO =new DBUtiliDAO(template,environment);
		dbUtiliDAO.updatePackagePMADB();
	}
	
	public void updateContractQuery(String environment) {
		template= new JdbcTemplate(datasource.getDataSource("pma"+environment));
		DBUtiliDAO dbUtiliDAO =new DBUtiliDAO(template,environment);
		dbUtiliDAO.updateContractPMADB();
	}

	public void updatePackageQuery(String environment, String packagecode) {
		// TODO Auto-generated method stub
		template= new JdbcTemplate(datasource.getDataSource("pma"+environment));
		DBUtiliDAO dbUtiliDAO =new DBUtiliDAO(template,environment);
		dbUtiliDAO.updatePackagePMADB(packagecode);
		
	}
}



