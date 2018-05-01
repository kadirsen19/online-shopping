package com.kadir.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = {"com.kadir.model"})
@EnableTransactionManagement
public class HibernateConfig {

	/*private final static String DATABASE_URL = "jdbc:h2:tcp://localhost/~/onlineshopping";
	private final static String DATABASE_DRIVER = "org.h2.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_USERNAME = "root";
	private final static String DATABASE_PASSWORD = "kadirsen";*/
	private final static String DATABASE_URL = "jdbc:mysql://localhost:3306/onlineshoppinddb?useSSL=false";
	private final static String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
	private final static String DATABASE_DIALECT = "org.hibernate.dialect.MySQLDialect";
	private final static String DATABASE_USERNAME = "root";
	private final static String DATABASE_PASSWORD = "kadirsen";
	/* Database bean */
	
	@Bean("dataSource")
	public DataSource getDataSource() {

		// database connection information
		BasicDataSource dataSource = new BasicDataSource();

		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setPassword(DATABASE_PASSWORD);
		return dataSource;

	}

	/* sessionFactory bean */
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {

		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

		builder.addProperties(getHibernateProporties());
		builder.scanPackages("com.kadir.model");
		return builder.buildSessionFactory();

	}

	/* Hibernate properties , can be added after */
	private Properties getHibernateProporties() {

		Properties properties = new Properties();

		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2dll.auto","create");

		return properties;
	}

	/* Transaction Manager Bean */
	@Bean
	public HibernateTransactionManager geTransactionManager(SessionFactory sessionFactory) {

		HibernateTransactionManager transaction = new HibernateTransactionManager(sessionFactory);

		return transaction;

	}


}
