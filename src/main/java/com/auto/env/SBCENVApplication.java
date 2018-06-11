package com.auto.env;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.auto.env.service.ApplicationScheduler;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableScheduling
public class SBCENVApplication{

	private static final Logger logger = LogManager.getLogger(SBCENVApplication.class);
	public static void main(String[] args) {
		logger.info("Starting Application");
		SpringApplication.run(SBCENVApplication.class, args);
	}

	/**
	 * This event is executed as late as conceivably possible to indicate that 
	 * the application is ready to service requests.
	 */
	@Autowired
	ApplicationScheduler applicationScheduler;
	
	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationEvent() {
		logger.debug("Starting Application Startup Operations");
		try {
			logger.debug("Start fetchAllPackagesFromDB");
			applicationScheduler.fetchAllPackagesFromDB();
		} catch (Exception e) {
			logger.error("onApplicationEvent --> fetchAllPackagesFromDB "+e);
		}
		try {
			logger.debug("Start fetchChannelDetails");
			applicationScheduler.fetchChannelDetails();
		} catch (Exception e) {
			logger.error("onApplicationEvent --> fetchChannelDetails "+e);
		}
		try {
			logger.debug("Start fetchRejectedPackagesFromDB");
			applicationScheduler.fetchRejectedPackagesFromDB();
		} catch (Exception e) {
			logger.error("onApplicationEvent --> fetchRejectedPackagesFromDB "+e);
		}
		logger.debug("Application Startup Operations Ended");
	}
}
