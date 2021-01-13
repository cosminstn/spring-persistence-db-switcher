package tech.sharply.spring.db_switcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import tech.sharply.spring.db_switcher.persistence.implementations.sql.config.SqlEngineConfiguration;

import javax.annotation.PostConstruct;

@Configuration
@ConditionalOnBean(SqlEngineConfiguration.class)
//@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
//public class SqlApp extends App {
@ComponentScan(excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = MongoAutoConfiguration.class)
})
public class SqlApp {

	private static final Logger LOG = LoggerFactory.getLogger(MongoApp.class);

	@PostConstruct
	public void init() {
		LOG.info("Started SqlApp");
	}

}


