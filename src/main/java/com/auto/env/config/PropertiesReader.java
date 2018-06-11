package com.auto.env.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.auto.env.constants.IConstants;

public class PropertiesReader implements IConstants{
	private static final Logger logger = LogManager.getLogger(PropertiesReader.class);
	
	private Properties p;
	public PropertiesReader() {
		FileReader reader = null;
		try {
			reader = new FileReader(FOLDER_PROPERTIES_FILE);
		} catch (FileNotFoundException e) {
			logger.error(FOLDER_PROPERTIES_FILE+" does not exist\n"+e);
		}  
		p=new Properties();  
		try {
			p.load(reader);
		} catch (IOException e) {
			logger.error("Error Loading Properties from "+FOLDER_PROPERTIES_FILE);
		}  
	}
	public String getDir(String env) {
		String basePath ="";
		try {
			logger.debug("getDir "+METHOD_START);
			basePath = p.getProperty("reports_"+env+"_dir");
			logger.debug("Directory for "+env+" is "+basePath);
			makeDirs(basePath);
			logger.debug("getDir "+METHOD_END);
		} catch (Exception e) {
			logger.error("Error in getDir"+e);
		}
		return basePath;
	}

	private void makeDirs(String basePath) {
		if(basePath!=null) {
			File folderBase = new File(basePath);
			if(!folderBase.exists()) {
				logger.debug("Created Directory "+basePath);
				folderBase.mkdirs();
			}
		}
	}
}