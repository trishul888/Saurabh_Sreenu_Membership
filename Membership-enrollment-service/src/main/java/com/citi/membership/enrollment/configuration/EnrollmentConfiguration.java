/**@Copyright 2021. All rights are reserved,you should disclose the infromation,otherwise terms and conditions will apply.  
 * 
 * 
 */
package com.citi.membership.enrollment.configuration;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author    ::asus
 * @Date      ::Apr 30, 2021
 * Description::
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.citi.membership.enrollment")
public class EnrollmentConfiguration {

	@Bean
	@Profile("prod")
	public PropertySourcesPlaceholderConfigurer prodEnvProperties() {
		System.out.println("Load production environment Properties file");
		PropertySourcesPlaceholderConfigurer placeHolder=new PropertySourcesPlaceholderConfigurer();
		placeHolder.setLocation(new ClassPathResource("properties/serivce/card-details-service-prod.properties"));
		return placeHolder;
	}

	@Bean
	public RestTemplate restTempate() {
		return new RestTemplate();
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///saurabh_sreenu");
		dataSource.setUsername("root");
		dataSource.setPassword("Saurabh23patre@");
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() throws NamingException {
		return new JdbcTemplate(dataSource());
	}
	/*
	@Bean
	public DataSource dataSource() throws NamingException  {
			DriverManagerDataSource dataSource=new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql:///saurabh_sreenu");
		dataSource.setUsername("root");
		dataSource.setPassword("Saurabh23patre@");
		return dataSource();
		 		Context ctx=new InitialContext();
		 //DataSource dataSource=(DataSource) ctx.lookup("java:/comp/env/DsJndi");
		 return (DataSource) new JndiTemplate().lookup("java:/comp/env/DsJndi");


	}*/
	/*
	private final Properties hibernateProperties() {
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQLDialect");
		hibernateProperties.setProperty("hibernate.show-sql","true");
		hibernateProperties.setProperty("hibernate.format-sql","true");
		return hibernateProperties;
	}
	private final SessionFactory sessionFactory() throws NamingException {
		LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource());
		localSessionFactoryBean.setHibernateProperties(hibernateProperties());
		localSessionFactoryBean.setPackagesToScan("com.citi.membership.enrollment.entities");
		return (SessionFactory) localSessionFactoryBean;
	}

	@Bean
	public HibernateTemplate hibernateTemplate() throws NamingException {
		HibernateTemplate hibernateTemplate=new HibernateTemplate();
		hibernateTemplate.setSessionFactory(sessionFactory());
		return hibernateTemplate;
	}
	 */
}
