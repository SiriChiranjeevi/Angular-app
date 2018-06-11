package com.auto.env.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.auto.env.config.DBConfig;
import com.auto.env.constants.IConstants;
import com.auto.env.dao.DBUtiliDAO;

@Service
public class ApplicationScheduler implements IConstants{
	private static final Logger logger = LogManager.getLogger(ApplicationScheduler.class);
	@Autowired
	DBConfig datasource;

	JdbcTemplate template;

	String[] envList = {"stage","training","shadow","production","load","latest"};

	List<String> addChanel = new ArrayList<String>();

	@Scheduled(cron = "0 0 */3 * * *")
	public void fetchAllPackagesFromDB() {
		logger.debug("fetchAllPackagesFromDB "+METHOD_START);
		for(String env : Arrays.asList(envList)) {
			try {
				logger.debug("Fetch Details for "+env+" Environment");
				template= new JdbcTemplate(datasource.getDataSource(env));
				DBUtiliDAO dbUtiliDAO =new DBUtiliDAO(template,env);
				dbUtiliDAO.fetchAllPackagesFromDB();
			} catch (Exception e) {
				logger.error("fetchAllPackagesFromDB for "+env+" "+e);
			}
		}
		logger.debug("fetchAllPackagesFromDB "+METHOD_END);
	}

	@Scheduled(cron = "0 0 */3 * * *")
	public void fetchRejectedPackagesFromDB() {
		logger.debug("fetchRejectedPackagesFromDB "+METHOD_START);
		for(String env : Arrays.asList(envList)) {
			try {
				logger.debug("Fetch Details for "+env+" Environment");
				template= new JdbcTemplate(datasource.getDataSource(env));
				DBUtiliDAO dbUtiliDAO =new DBUtiliDAO(template,env);
				dbUtiliDAO.fetchRejectedPackagesFromDB();
			} catch (Exception e) {
				logger.error("fetchRejectedPackagesFromDB for "+env+" "+e);
			}
		}
		logger.debug("fetchRejectedPackagesFromDB "+METHOD_END);
	}

	@Scheduled(cron = "0 0 6 * * *")
	public void fetchChannelDetails() {
		logger.debug("fetchChannelDetails "+METHOD_START);
		for(String env : Arrays.asList(envList)) {
			try {
				logger.debug("Fetch Details for "+env+" Environment");
				template= new JdbcTemplate(datasource.getDataSource(env));
				DBUtiliDAO dbUtiliDAO =new DBUtiliDAO(template,env);
				dbUtiliDAO.fetchChannelDetails();
			} catch (Exception e) {
				logger.error("fetchChannelDetails for "+env+" "+e);
			}
		}
		logger.debug("fetchChannelDetails "+METHOD_END);
	}
	
	@Scheduled(cron="0 0 21 * * *")
	public void fetchPMADetrails() {
		logger.debug("fetchPMADetrails "+METHOD_START);
		for(String env : Arrays.asList(envList)) {
			try {
				logger.debug("Fetch Details for "+env+" Environment");
				template= new JdbcTemplate(datasource.getDataSource("pma"+env));
				DBUtiliDAO dbUtiliDAO =new DBUtiliDAO(template,env);
				dbUtiliDAO.updatePMADB();
			} catch (Exception e) {
				logger.error("fetchPMADetrails for "+env+" "+e);
			}
		}
		logger.debug("fetchPMADetrails "+METHOD_END);
	}
}
