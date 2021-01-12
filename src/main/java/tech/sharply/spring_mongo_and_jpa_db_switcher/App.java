package tech.sharply.spring_mongo_and_jpa_db_switcher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class App implements CommandLineRunner {

	private static final Logger LOG = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Running cli app");
		Thread.sleep(5000);
	}
}
