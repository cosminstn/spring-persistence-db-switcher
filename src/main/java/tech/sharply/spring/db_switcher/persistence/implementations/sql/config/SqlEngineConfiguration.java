package tech.sharply.spring.db_switcher.persistence.implementations.sql.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories
@ConditionalOnProperty("spring.datasource.url")
public class SqlEngineConfiguration {

	private static final Logger log = LoggerFactory.getLogger(SqlEngineConfiguration.class);

	@Value("${spring.datasource.url:#{null}}")
	private String url;
	@Value("${spring.datasource.username:#{null}}")
	private String username;
	@Value("${spring.datasource.password:#{null}}")
	private String password;

	@Bean
	public DataSource dataSource() {
		var dataSourceBuilder = DataSourceBuilder.create();
		// The driver name should be determined automatically
		dataSourceBuilder.url(url);
		dataSourceBuilder.username(username);
		dataSourceBuilder.password(password);

		var datasource = dataSourceBuilder.build();
		log.info("SQL data source registered for url: " + url);
		return datasource;
	}

//	private HibernateJpaVendorAdapter vendorAdaptor() {
//		var vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setShowSql(true);
//		return vendorAdapter;
//	}

//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {
//
//		var entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//		entityManagerFactoryBean.setJpaVendorAdapter(vendorAdaptor());
//		entityManagerFactoryBean.setDataSource(dataSource());
//		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
////		entityManagerFactoryBean.setPackagesToScan(ENTITYMANAGER_PACKAGES_TO_SCAN);
////		entityManagerFactoryBean.setJpaProperties(jpaHibernateProperties());
//
//		return entityManagerFactoryBean;
//	}

}
