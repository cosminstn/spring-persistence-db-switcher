package tech.sharply.spring.db_switcher.persistence.entities;

import java.io.Serializable;

public interface User {

	Serializable getId();

	String getUsername();

	String getPassword();

}
