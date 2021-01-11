package tech.sharply.spring_mongo_and_jpa_db_switcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import tech.sharply.spring_mongo_and_jpa_db_switcher.persistence.implementations.sql.config.SqlEngineConfiguration;

import javax.annotation.PostConstruct;

@ConditionalOnBean(SqlEngineConfiguration.class)
@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
public class SqlApp extends App {

	private static final Logger LOG = LoggerFactory.getLogger(MongoApp.class);

	@PostConstruct
	public void init() {
		LOG.info("Started SqlApp");
	}

}


