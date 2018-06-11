package com.auto.env.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auto.env.constants.IConstants;
import com.auto.env.dao.ApplicationDAO;
import com.auto.env.dao.PmaDAO;
import com.auto.env.model.PackageValidation;
import com.auto.env.model.ProductBuilder;

@Service
public class ApplicationService implements IConstants{
	 
	private static final Logger logger = LogManager.getLogger(ApplicationService.class);
	
	@Autowired
	ApplicationDAO applicationDAO;
	
	@Autowired
	PmaDAO pmadao;

	public List<ProductBuilder> getPackageDetails(String rootContext) {
		logger.debug(CALLED_STR+rootContext+"/getPackageDetails");
		return applicationDAO.getAllPackageDetails(rootContext);
	}
	
	public List<PackageValidation> getRejectedPackages(String rootContext) {
		logger.debug(CALLED_STR+rootContext+"/getRejectedPackages");
		return applicationDAO.getRejectedPackageDetails(rootContext);
	}

	public void updateQuery(String environment) {
		logger.debug(CALLED_STR+"/pma/"+environment);
		pmadao.updateQuery(environment);
	}
	
	public void updatePackageQuery(String environment) {
		logger.debug(CALLED_STR+"/pma/"+environment);
		pmadao.updatePackageQuery(environment);
	}
	
	public void updateContractQuery(String environment) {
		logger.debug(CALLED_STR+"/pma/"+environment);
		pmadao.updateContractQuery(environment);
	}

	public void updatePackageQuery(String environment, String packagecode) {
		// TODO Auto-generated method stub
		logger.debug(CALLED_STR+"/pma/"+environment);
		pmadao.updatePackageQuery(environment, packagecode);
		
	}
}



