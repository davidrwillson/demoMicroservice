package org.demo.data.zone;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import org.demo.common.util.Constants;
import org.demo.common.util.DemoUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Import;

//import EurekaConfigBean
//import RestTemplateConfiguration
//import OAuthInterceptorConfig
//import VersionCheckConfiguration

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
//@Import({RestTemplateConfiguration.class, OAuthInterceptorConfig.class, SwarmService.class, VersionCheckConfiguration.class})
@ComponentScan({"org.demo.common"})
public class DemoDataApplication {
	
	private static final Logger LOG = Logger.getLogger(DemoDataApplication.class);
	
	@Value("${spring.datasource.url}")
	private String dbUrl;
	
	@Value("${spring.datasource.username}")
	private String dbUsername;
	
	@Value("${spring.datasource.password}")
	private String dbPassword;
	
	@Value("${spring.datasource.driver-class-name}")
	private String dbDriverClassName;
	
	@Value("${spring.datasource.min-idle-connections}")
	private int dbMinIdleConnections;
	
	@Value("${spring.datasource.max-idle-connections}")
	private int dbMaxIdleConnections;
	
	@Value("${spring.datasource.init-connections}")
	private int dbInitConnections;
	
	@Bean
	DataSource dataSource() {		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(dbUsername);
		dataSource.setPassword(dbPassword);
		dataSource.setDriverClassName(dbDriverClassName);
		dataSource.setMinIdle(dbMinIdleConnections);
		dataSource.setMaxIdle(dbMaxIdleConnections);
		dataSource.setInitialSize(dbInitConnections);
		return dataSource;		
	}
	
	public static void main(final String[] args) throws Exception {
	    System.setProperty(Constants.HOSTNAME, DemoUtil.getHostname());
        SpringApplication.run(DemoDataApplication.class, args);
    }
	
}
