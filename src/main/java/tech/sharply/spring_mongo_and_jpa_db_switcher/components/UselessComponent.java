package tech.sharply.spring_mongo_and_jpa_db_switcher.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UselessComponent {

	public static final Logger LOG = LoggerFactory.getLogger(UselessComponent.class);

	@Scheduled(fixedRate = 10_000)
	public void printAlive() {
		LOG.info("Still alive...");
	}

}
