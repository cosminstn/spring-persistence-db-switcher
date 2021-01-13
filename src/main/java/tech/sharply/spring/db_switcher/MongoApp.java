package tech.sharply.spring.db_switcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import tech.sharply.spring.db_switcher.persistence.implementations.nosql.config.MongoEngineConfiguration;

import javax.annotation.PostConstruct;

@Configuration
@ConditionalOnBean(MongoEngineConfiguration.class)
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ComponentScan(excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = DataSourceAutoConfiguration.class),
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = HibernateJpaAutoConfiguration.class),
})
//public class MongoApp extends App {
public class MongoApp {

	private static final Logger LOG = LoggerFactory.getLogger(MongoApp.class);

	@PostConstruct
	public void init() {
		LOG.info("Started MongoApp");
	}

}
