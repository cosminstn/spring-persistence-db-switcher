package tech.sharply.spring.db_switcher.persistence.implementations.sql.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(basePackages = "tech.sharply.spring.db_switcher.persistence.implementations.sql")
@ConditionalOnProperty(prefix = "spring.datasource", value = "url")
public class SqlEngineConfiguration {

	private static final Logger log = LoggerFactory.getLogger(SqlEngineConfiguration.class);

	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource primaryDataSource() {
		log.info("SQL DB Engine detected!");
		return DataSourceBuilder.create().build();
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
