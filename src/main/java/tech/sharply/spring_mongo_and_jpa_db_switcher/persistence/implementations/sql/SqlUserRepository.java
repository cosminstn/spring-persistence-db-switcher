package tech.sharply.spring_mongo_and_jpa_db_switcher.persistence.implementations.sql;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.sharply.spring_mongo_and_jpa_db_switcher.persistence.implementations.sql.config.SqlEngineConfiguration;

@ConditionalOnBean(SqlEngineConfiguration.class)
@Repository
public interface SqlUserRepository extends JpaRepository<SqlUser, Integer> {
}
