package tech.sharply.spring_mongo_and_jpa_db_switcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;
import tech.sharply.spring_mongo_and_jpa_db_switcher.persistence.implementations.nosql.config.MongoEngineConfiguration;

import javax.annotation.PostConstruct;

//@ConditionalOnBean(MongoEngineConfiguration.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableScheduling
public class MongoApp extends App {

	private static final Logger LOG = LoggerFactory.getLogger(MongoApp.class);

	@PostConstruct
	public void init() {
		LOG.info("Started MongoApp");
	}

}
