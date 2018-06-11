package com.auto.env.dao;

import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.auto.env.config.DBConfig;
import com.auto.env.config.PropertiesReader;
import com.auto.env.constants.IConstants;
import com.auto.env.model.Package;
import com.auto.env.model.ProductBuilder;
import com.auto.env.model.SalesChannels;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
@Component
public class PMASubClassDAO implements IConstants{
	
	@Autowired
	DBConfig datasource;
	
	JdbcTemplate template;
	
	private static final Logger logger = LogManager.getLogger(PMASubClassDAO.class);
	
	private String environment;
	
	PropertiesReader propertiesReader = new PropertiesReader();

	
	
	public List<ProductBuilder> getPackageDetails(String environment,String GT_CODE) {
		template= new JdbcTemplate(datasource.getDataSource(environment));
		
		logger.debug("getPackageDetails for environment "+environment+" "+METHOD_START);
		
		/*List<ProductBuilder> productlist = template.query(getpackageDetailasQuery, ps->{ps.setString(1, GT_CODE);},(result, rowNum)->{ return new ProductBuilder(result.getString(PBL_DATE), result.getString(GT_CODE),
				result.getString(ACTION), result.getString(CHANNEL));});
		logger.info("Query Result ->> "+productlist);*/
			
		List<ProductBuilder> productlist = template.query(getpackageDetailasQuery, ps->ps.setString(1, GT_CODE), new ProductBuilderRowMapper());
		logger.info("Query Result ->> "+productlist);
		
		
		
		System.out.println(productlist);
		logger.debug("fetchChannelDetails "+METHOD_END);
				
		
		return productlist;
	}
	
	
	public static class ProductBuilderRowMapper implements RowMapper
	{
		
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			ProductBuilder product = new ProductBuilder();
			product.setGT_CODE(rs.getString("GT_CODE"));
			product.setCHANNEL(rs.getString("CHANNEL"));
			product.setACTION(rs.getString("ACTION"));
			product.setPBL_DATE(rs.getString("PBL_DATE"));
			
			return product;
		}
		
	}
	
	
	public List<SalesChannels> getSalesChannelObj(String environment, String CHANNEL) {
		template= new JdbcTemplate(datasource.getDataSource(environment));
		String channel=CHANNEL.toUpperCase();
		 Object[] inputs = new Object[] {CHANNEL};
		 
		 RowMapper<SalesChannels> rowMapper = (rs, rowNum) -> {
			 SalesChannels sc = new SalesChannels();
			 sc.setCHANNEL(rs.getString("CHANNEL"));
			 sc.setISINCLUDED(rs.getString("ISINCLUDED"));
			 return sc;
			 };
		 
		    
			//SalesChannels sc2=template.queryForObject(getchanelsObjQuery, new Object[] {channel}, rowMapper);
			List<SalesChannels> productlist = template.query(getchanelsObjQuery, ps->ps.setString(1, channel), rowMapper);
			System.out.println("11111************************"+productlist);
			return  productlist;
			
	}
	
	

}
