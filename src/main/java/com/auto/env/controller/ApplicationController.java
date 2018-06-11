package com.auto.env.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.auto.env.constants.IConstants;
import com.auto.env.model.PackageValidation;
import com.auto.env.model.ProductBuilder;
import com.auto.env.service.ApplicationService;

@RestController
@RequestMapping(value= {"/stage","/training","/shadow","/production","/load","/latest"})
public class ApplicationController  implements IConstants{
	private static final Logger logger = LogManager.getLogger(ApplicationController.class);

	@Autowired
	ApplicationService applicationService;

	@RequestMapping("/getPackageDetails")
	public List<ProductBuilder> getPackageDetails(HttpServletRequest request) {
		String rootContext = getRootContext(request);
		logger.debug(CALLED_STR+rootContext+"/getPackageDetails");
		return applicationService.getPackageDetails(rootContext);
	}

	@RequestMapping("/getRejectedPackages")
	public List<PackageValidation> getRejectedPackages(HttpServletRequest request) {
		String rootContext = getRootContext(request);
		logger.debug(CALLED_STR+rootContext+"/getRejectedPackages");
		return applicationService.getRejectedPackages(rootContext);
	}
	
	private String getRootContext(HttpServletRequest request) {
		String rootContext = (String) request.getAttribute(
				HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		rootContext = rootContext.split("/")[1];
		return rootContext;
	}
}
