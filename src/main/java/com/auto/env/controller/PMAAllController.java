package com.auto.env.controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import com.auto.env.constants.IConstants;
import com.auto.env.service.ApplicationService;

@RestController
@RequestMapping("/pma")
public class PMAAllController implements IConstants{

	private static final String PARENT_VIEW_MAP = "/pma";

	private static final Logger logger = LogManager.getLogger(PMAAllController.class);

	@Autowired
	ApplicationService applicationService;
	
	@RequestMapping(value= {"/stage","/training","/shadow","/production","/load","/latest"})
	public String pmashadowupdate(@RequestParam String username, @RequestParam String password ,HttpServletRequest request) {
		logger.debug(CALLED_STR+PARENT_VIEW_MAP+request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE));
		String user=username;
		String key=password;
		if(user.equalsIgnoreCase("admin")&& key.equals("admin"))
		{
			String environment = getEnvironmentContext(request);
			
			String pmaprocess=environment;
			/*applicationService.updateQuery(environment);
			logger.info("Authentication SuccessFull"); */
			logger.debug(CALLED_STR+PARENT_VIEW_MAP+"----> env : "+pmaprocess);
			return pmaprocess;
		}else {
			logger.info("Authentication Failed");
			return "Authentication Failed";
		}
	}
	private String getEnvironmentContext(HttpServletRequest request) {
		String rootContext = (String) request.getAttribute(
				HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		rootContext = rootContext.split("/")[2];
		return rootContext;
	}
	@RequestMapping(value= {"/stage/pmaupdate","/training/pmaupdate","/shadow/pmaupdate","/production/pmaupdate","/load/pmaupdate","/latest/pmaupdate"})
	public String getUpdtaeQuesry(HttpServletRequest request) {
		String environment = getEnvironmentContext(request);
		applicationService.updateQuery(environment);
		logger.info("Update PMA Updated SuccessFull");
		
		return "Full Sync (PMA) Successfully Done";
	}
	
	@RequestMapping(value= {"/stage/packageupdate","/training/packageupdate","/shadow/packageupdate","/production/packageupdate","/load/packageupdate","/latest/packageupdate"})
	public String getPackageUpdate(HttpServletRequest request) {
		String environment = getEnvironmentContext(request);
		System.out.println("Package Update..."+environment);
		applicationService.updatePackageQuery(environment);
		logger.info("Update PMA Package Updated SuccessFull");
		
		return "Package Based Sync Successfully Done";
	}
	
	@RequestMapping(value= {"/stage/contractupdate","/training/contractupdate","/shadow/contractupdate","/production/contractupdate","/load/contractupdate","/latest/contractupdate"})
	public String getContractUpdate(HttpServletRequest request) {
		String environment = getEnvironmentContext(request);
		System.out.println("Contract Update..."+environment);
		applicationService.updateContractQuery(environment);
		logger.info("Update PMA Contract Updated SuccessFull");
		
		return "Contract Based Sync Successfully Done";
	}
	
	@RequestMapping(value= {"/stage/packagecodeupdate","/training/packagecodeupdate","/shadow/packagecodeupdate","/production/packagecodeupdate","/load/packagecodeupdate","/latest/packagecodeupdate"})
	public String getPackageCodeUpdate(@RequestParam String pkg_code, HttpServletRequest request) {
		String packagecode=pkg_code.toUpperCase();
		String environment = getEnvironmentContext(request);
		System.out.println("Package Code Update..."+environment);
		applicationService.updatePackageQuery(environment, packagecode);
		logger.info("Update PMA Package Code Updated SuccessFull");
		
		return "Package Based Sync Successfully Done....";
	}
}