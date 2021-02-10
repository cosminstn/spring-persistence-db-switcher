package tech.sharply.spring.db_switcher.persistence.entities;

import java.io.Serializable;
import java.util.UUID;

public interface User {

	UUID getId();

	String getUsername();

	String getPassword();

}
