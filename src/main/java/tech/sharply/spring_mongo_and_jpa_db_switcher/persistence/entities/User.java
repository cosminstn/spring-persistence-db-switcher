package tech.sharply.spring_mongo_and_jpa_db_switcher.persistence.entities;

import java.io.Serializable;

public interface User {

	Serializable getId();

	String getUsername();

	String getPassword();

}
