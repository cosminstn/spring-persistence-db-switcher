package tech.sharply.spring.db_switcher.persistence.repositories;

import org.springframework.data.repository.CrudRepository;
import tech.sharply.spring.db_switcher.persistence.entities.User;

import java.util.UUID;

public interface UserRepository<T extends User> extends CrudRepository<T, UUID> {
}
