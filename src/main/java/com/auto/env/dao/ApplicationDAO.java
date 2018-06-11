package com.auto.env.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.auto.env.config.DBConfig;
import com.auto.env.model.PackageValidation;
import com.auto.env.model.ProductBuilder;

@Component
public class ApplicationDAO {
	@Autowired
	DBConfig datasource;
	
	JdbcTemplate template;
	
	List<String> addChanel = new ArrayList<String>();

	public List<ProductBuilder> getAllPackageDetails(String environment) {
		 template= new JdbcTemplate(datasource.getDataSource(environment));
			DBUtiliDAO dbUtiliDAO =new DBUtiliDAO(template,environment);
		return dbUtiliDAO.getAllPackageDetails();
	}	

	public List<PackageValidation> getRejectedPackageDetails(String environment) {
		template= new JdbcTemplate(datasource.getDataSource(environment));
		DBUtiliDAO dbUtiliDAO =new DBUtiliDAO(template,environment);
		return dbUtiliDAO.getRejectedPackageDetails();
	}
}
