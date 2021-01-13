package tech.sharply.spring.db_switcher;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import tech.sharply.spring.db_switcher.persistence.implementations.nosql.MongoUser;

import java.util.List;

@Configuration
@ConditionalOnProperty("spring.data.mongodb.database")
@ComponentScan(excludeFilters = {
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = DataSourceAutoConfiguration.class),
		@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = HibernateJpaAutoConfiguration.class),
})
@EnableMongoRepositories
public class MongoEngineConfiguration extends AbstractMongoClientConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(MongoEngineConfiguration.class);

	@Value("${spring.data.mongodb.host}")
	private String mongoHost;

	@Value("${spring.data.mongodb.port}")
	private Integer mongoPort;

	@Value("${spring.data.mongodb.database}")
	private String mongoDB;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private MongoMappingContext mongoMappingContext;

	@EventListener(ApplicationReadyEvent.class)
	public void initIndicesAfterStartup() {
		IndexResolver resolver = new MongoPersistentEntityIndexResolver(mongoMappingContext);

		List<Class<?>> entities = List.of(MongoUser.class);
		for (var clazz : entities) {
			IndexOperations indexOps = mongoTemplate.indexOps(clazz);
			resolver.resolveIndexFor(clazz).forEach(indexOps::ensureIndex);
		}
		LOG.info("MongoDB indices created!");
	}

	@Override
	public MongoClient mongoClient() {
		var connectionString = new ConnectionString(String.format("mongodb://%s:%d/%s", mongoHost, mongoPort, mongoDB));
		var mongoClientSettings = MongoClientSettings.builder()
				.applyConnectionString(connectionString)
				.build();

		return MongoClients.create(mongoClientSettings);
	}

	@Override
	protected String getDatabaseName() {
		return mongoDB;
	}

}
