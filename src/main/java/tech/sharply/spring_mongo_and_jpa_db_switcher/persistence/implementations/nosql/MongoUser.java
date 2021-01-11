package tech.sharply.spring_mongo_and_jpa_db_switcher.persistence.implementations.nosql;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;
import tech.sharply.spring_mongo_and_jpa_db_switcher.persistence.entities.User;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class MongoUser implements User {

	@Id
	private ObjectId id;
	@NonNull
	private String username;
	@NonNull
	private String password;


}
