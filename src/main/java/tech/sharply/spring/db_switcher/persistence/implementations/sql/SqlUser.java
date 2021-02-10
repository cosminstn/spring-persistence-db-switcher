package tech.sharply.spring.db_switcher.persistence.implementations.sql;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.springframework.lang.NonNull;
import tech.sharply.spring.db_switcher.persistence.entities.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
public class SqlUser implements User {

	@Id
	@GeneratedValue
	@Type(type="uuid-char")
	private UUID id;
	@NonNull
	private String username;
	@NonNull
	private String password;

}
