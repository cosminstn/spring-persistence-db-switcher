package tech.sharply.spring_mongo_and_jpa_db_switcher.persistence.implementations.nosql;

import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.sharply.spring_mongo_and_jpa_db_switcher.persistence.implementations.nosql.config.MongoEngineConfiguration;

@ConditionalOnBean(MongoEngineConfiguration.class)
@Repository
public interface MongoUserRepository extends MongoRepository<MongoUser, ObjectId> {
}
