package tech.sharply.spring.db_switcher.persistence.services;

import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.sharply.spring.db_switcher.persistence.config.DatabaseEngineIdentifier;
import tech.sharply.spring.db_switcher.persistence.config.UniversalRepositorySelector;
import tech.sharply.spring.db_switcher.persistence.entities.User;
import tech.sharply.spring.db_switcher.persistence.implementations.nosql.MongoUser;
import tech.sharply.spring.db_switcher.persistence.implementations.nosql.MongoUserRepository;
import tech.sharply.spring.db_switcher.persistence.implementations.sql.SqlUser;
import tech.sharply.spring.db_switcher.persistence.implementations.sql.SqlUserRepository;
import tech.sharply.spring.db_switcher.persistence.repositories.UserRepository;

import javax.annotation.PostConstruct;

@Service
public class UserService extends UniversalRepositorySelector<SqlUserRepository, MongoUserRepository,
		UserRepository<? extends User>, UserRepository<User>> {

	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	public UserService(
			@Autowired BeanFactory beanFactory,
			@Autowired DatabaseEngineIdentifier databaseEngineIdentifier) {
		super(SqlUserRepository.class, MongoUserRepository.class, beanFactory, databaseEngineIdentifier.getEngine());
	}

	public User save(@NonNull User user) {
		return getRepository().save(user);
	}

}
