package com.auto.env.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:db.properties")
public class DBConfig {
	
	@Autowired
	Environment env;

	//Get DB Connection
	public DataSource getDataSource(String environment) {
		String url=env.getProperty("mysql."+environment+".url");
		String user=env.getProperty("mysql."+environment+".username");
		String password=env.getProperty("mysql."+environment+".password");
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(user);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();  
	}
}
