package tech.sharply.spring_mongo_and_jpa_db_switcher.persistence.implementations.sql;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;
import tech.sharply.spring_mongo_and_jpa_db_switcher.persistence.entities.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class SqlUser implements User {

	@Id
	@GeneratedValue
	private Integer id;
	@NonNull
	private String username;
	@NonNull
	private String password;

}
