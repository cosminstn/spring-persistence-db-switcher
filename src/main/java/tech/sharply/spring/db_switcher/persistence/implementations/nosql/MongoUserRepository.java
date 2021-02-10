package tech.sharply.spring.db_switcher.persistence.implementations.nosql;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.sharply.spring.db_switcher.MongoEngineConfiguration;
import tech.sharply.spring.db_switcher.persistence.repositories.UserRepository;

import java.util.UUID;

@ConditionalOnBean(MongoEngineConfiguration.class)
@Repository
public interface MongoUserRepository extends MongoRepository<MongoUser, UUID>, UserRepository<MongoUser> {
}
