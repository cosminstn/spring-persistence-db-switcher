package tech.sharply.spring.db_switcher.persistence.config;

import lombok.NonNull;
import org.springframework.beans.factory.BeanFactory;

/**
 * Is able to select the appropriate repository extension SQL/NOSQL for a specified repository.
 * @param <SR> - The SQL repository type
 * @param <MR> - The NoSQL repository type
 * @param <R>  - The repository type
 * @param <TR> - The target repository type
 */
public class UniversalRepositorySelector<SR extends R, MR extends R, R, TR> {

	private final Class<SR> sqlRepositoryClass;
	private final Class<MR> mongoRepositoryClass;
	private final BeanFactory beanFactory;
	private final DatabaseEngineIdentifier.DatabaseEngine databaseEngine;

	public UniversalRepositorySelector(
			@NonNull Class<SR> sqlRepositoryClass,
			@NonNull Class<MR> mongoRepositoryClass,
			@NonNull BeanFactory beanFactory,
			@NonNull DatabaseEngineIdentifier.DatabaseEngine databaseEngine) {
		this.sqlRepositoryClass = sqlRepositoryClass;
		this.mongoRepositoryClass = mongoRepositoryClass;
		this.beanFactory = beanFactory;
		this.databaseEngine = databaseEngine;
	}

	public Class<? extends R> getRepositoryClass() {
		return databaseEngine == DatabaseEngineIdentifier.DatabaseEngine.SQL ?
				sqlRepositoryClass : mongoRepositoryClass;
	}

	@SuppressWarnings("unchecked")
	public TR getRepository() {
		return (TR) beanFactory.getBean(getRepositoryClass());
	}

}
