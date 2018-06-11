package com.auto.env.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.auto.env.config.PropertiesReader;
import com.auto.env.constants.IConstants;
import com.auto.env.model.PackageValidation;
import com.auto.env.model.ProductBuilder;
import com.auto.env.model.SalesChannels;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class DBUtiliDAO implements IConstants{
	List<String> addChanel = new ArrayList<String>();
	private static final Logger logger = LogManager.getLogger(DBUtiliDAO.class);
	private JdbcTemplate template;
	private String environment;

	PropertiesReader propertiesReader = new PropertiesReader();

	public DBUtiliDAO(JdbcTemplate template, String environment) {
		super();
		this.template = template;
		this.environment = environment;
	}

	public void  fetchAllPackagesFromDB() {
		logger.debug("fetchAllPackagesFromDB for environment "+environment+" "+METHOD_START);

		List<ProductBuilder> pkgitems = template.query(acceptedpackageQuery,
				(result, rowNum) -> new ProductBuilder(result.getString(PBL_DATE), result.getString(GT_CODE),
						result.getString(ACTION), result.getString(CHANNEL)));
		logger.info("Query Result ->> "+pkgitems);
		String fileName = getFileName(ALL_PACKAGES_FNAME);
		try (FileWriter writer = new FileWriter(fileName)) {
			StatefulBeanToCsv<ProductBuilder> beanToCsv = new StatefulBeanToCsvBuilder<ProductBuilder>(writer).build();
			beanToCsv.write(pkgitems);
		} catch (Exception e) {
			logger.error("fetchAllPackagesFromDB "+e);
		}
		pkgitems.clear();
		logger.debug("fetchAllPackagesFromDB "+METHOD_END);
	}

	public List<ProductBuilder> getAllPackageDetails() {
		logger.debug("getAllPackageDetails "+METHOD_START);
		List<ProductBuilder> listObj = new ArrayList<>();
		try {
			String fileName = getFileName(ALL_PACKAGES_FNAME);
			File file = new File(fileName);
			if(file.exists()) {
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					ProductBuilder builder =  getProductBuilderObj(line);
					if(null != builder)
						listObj.add(builder);
				}
				fileReader.close();
			}else {
				logger.info("File Not Found --->"+file.getAbsolutePath());
			}
		} catch (IOException e) {
			logger.error("getAllPackageDetails ",e);
		}
		if(listObj.size() > 0) {
			listObj.remove(0);
			logger.info("Result After Reading CSV ->> "+listObj);
		}
		logger.debug("getAllPackageDetails "+METHOD_END);
		return listObj;
	}

	public void fetchRejectedPackagesFromDB() {
		logger.debug("fetchRejectedPackagesFromDB for environment "+environment+" "+METHOD_START);
		String fileName = getFileName(REJECTED_PACKAGES_FNAME);
		List<ProductBuilder> regpkgitems = template.query(rejectedPackagesQuery,
				(result, rowNum) -> new ProductBuilder(result.getString(PBL_DATE), result.getString(GT_CODE),
						result.getString(ACTION), result.getString(CHANNEL), result.getString(PBL_RETMSG)));
		logger.info("Query Result ->> "+regpkgitems);
		try (FileWriter writer = new FileWriter(fileName)) {
			StatefulBeanToCsv<ProductBuilder> beanToCsv = new StatefulBeanToCsvBuilder<ProductBuilder>(writer).build();
			beanToCsv.write(regpkgitems);
		} catch (Exception e) {
			logger.error("fetchRejectedPackagesFromDB ",e);
		}
		logger.debug("fetchRejectedPackagesFromDB "+METHOD_END);
	}

	public List<PackageValidation> getRejectedPackageDetails() {
		logger.debug("getRejectedPackageDetails "+METHOD_START);
		List<PackageValidation> listObj = new ArrayList<>();
		try {
			String fileName = getFileName(REJECTED_PACKAGES_FNAME);
			File file = new File(fileName);
			if(file.exists()) { 
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					listObj.add(getRejPackageObj(line));
				}
				fileReader.close();
			}else {
				logger.info("File Not Found --->"+file.getAbsolutePath());
			}
		} catch (IOException e) {
			logger.error("getRejectedPackageDetails ",e);
		}
		if(listObj.size() > 0) {
			listObj.remove(0);
			logger.info("Result After Reading CSV ->> "+listObj);
		}
		logger.debug("getRejectedPackageDetails "+METHOD_END);
		return listObj;
	}

	public void fetchChannelDetails() {
		logger.debug("fetchChannelDetails for environment "+environment+" "+METHOD_START);
		List<SalesChannels> salesitems = template.query(channelsQuery,
				(result, rowNum) -> new SalesChannels(result.getString(CHANNEL)));
		logger.info("Query Result ->> "+salesitems);
		String fileName = getFileName(CHANNEL_FNAME);
		try (FileWriter writer = new FileWriter(fileName)) {
			StatefulBeanToCsv<SalesChannels> beanToCsv = new StatefulBeanToCsvBuilder<SalesChannels>(writer).build();
			beanToCsv.write(salesitems);
		} catch (Exception e) {
			logger.error("fetchChannelDetails ",e);
		}
		logger.debug("fetchChannelDetails "+METHOD_END);
	}

	public List<SalesChannels> getChannel() {
		logger.debug("getChannel "+METHOD_START);
		List<SalesChannels> listObj = new ArrayList<>();
		try {
			String fileName = getFileName(CHANNEL_FNAME);
			File file = new File(fileName);
			if(file.exists()) {
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				bufferedReader.readLine();
				while ((line = bufferedReader.readLine()) != null) {
					listObj.add(getChannelObj(line));
				}
				fileReader.close();
			}else {
				logger.info("File Not Found --->"+file.getAbsolutePath());
			}
		} catch (IOException e) {
			logger.error("getChannel ",e);
		}
		if(listObj.size() > 0) {
			logger.info("Result After Reading CSV ->> "+listObj);
		}
		logger.debug("getChannel "+METHOD_END);
		return listObj;
	}

	public void updatePMADB() {
		logger.debug("updatePMADB "+METHOD_START);
		try {
			template.update(updatePMADB);
		} catch (DataAccessException e) {
			logger.error("updatePMADB ",e);
		}  
		logger.debug("updatePMADB "+METHOD_END);
	}

	private ProductBuilder getProductBuilderObj(String line) {
		ProductBuilder builder = null;
		String s1 = "REJECTED";
		String[] splitVal = line.split(COMMA_STRING);
		if (!splitVal[0].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim().equalsIgnoreCase(s1)) {
			builder = new ProductBuilder();
			builder.setACTION(splitVal[0].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
			builder.setCHANNEL(splitVal[1].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
			builder.setGT_CODE(splitVal[2].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
			builder.setPBL_DATE(splitVal[3].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
			builder.setPBL_RETMSG(splitVal[4].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
		}
		return builder;
	}

	private SalesChannels getChannelObj(String line) {
		SalesChannels sales = new SalesChannels();

		String[] splitVal = line.split(COMMA_STRING);
		String singlechannel=splitVal[0].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim();

		addChanel.add(singlechannel);
		sales.setCHANNEL(splitVal[0].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
		return sales;
	}

	private PackageValidation getRejPackageObj(String line) {
		PackageValidation regpke = new PackageValidation();
		String[] splitVal = line.split(COMMA_STRING);
		if(addChanel.contains(splitVal[1].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim())) {
			regpke.setACTION(splitVal[0].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
			regpke.setCHANNEL(splitVal[1].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
			regpke.setGT_CODE(splitVal[2].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
			regpke.setPBL_DATE(splitVal[3].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
			regpke.setPBL_RETMSG(splitVal[4].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
			regpke.setValidation("Not Validated");
		}
		else {
			regpke.setACTION(splitVal[0].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
			regpke.setCHANNEL(splitVal[1].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
			regpke.setGT_CODE(splitVal[2].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
			regpke.setPBL_DATE(splitVal[3].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
			regpke.setPBL_RETMSG(splitVal[4].replace(DOUBLE_QUOTE_STRING, NO_SPACE_STRING).trim());
			regpke.setValidation("Validated");
		}
		return regpke;
	}
	
	public void updatePackagePMADB() {
		logger.debug("updatePackagePMADB "+METHOD_START);
		try {
			template.update(updatePackagePMADB);
		} catch (DataAccessException e) {
			logger.error("updatePackagePMADB ",e);
		}  
		logger.debug("updatePackagePMADB "+METHOD_END);
	}
	
	public void updateContractPMADB() {
		logger.debug("updateContractPMADB "+METHOD_START);
		try {
			template.update(updateContractPMADB);
		} catch (DataAccessException e) {
			logger.error("updateContractPMADB ",e);
		}  
		logger.debug("updateContractPMADB "+METHOD_END);
	}
	

	private String getFileName(String fileName) {
		return propertiesReader.getDir(environment)+"/"+fileName + REPORT_FILE_EXTENSION;
	}

	public void updatePackagePMADB(String packagecode) {
		// TODO Auto-generated method stub

		logger.debug("updatePackagePMADB "+METHOD_START);
		try {
			template.update(updatePackageCodePMADB, packagecode );
		} catch (DataAccessException e) {
			logger.error("updatePackagePMADB ",e);
		}  
		logger.debug("updatePackagePMADB "+METHOD_END);
	
		
	}
}
