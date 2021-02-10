package tech.sharply.spring.db_switcher.persistence.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.sharply.spring.db_switcher.persistence.implementations.sql.SqlUser;
import tech.sharply.spring.db_switcher.persistence.implementations.sql.SqlUserRepository;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

	@Autowired
	private UserService userService;

	@Autowired
	private SqlUserRepository sqlUserRepository;

	@Test
	void save() {
		for (var i = 0; i < 5; i++) {
			var sqlUser = new SqlUser();
			var uuid = UUID.randomUUID().toString();
			sqlUser.setUsername("user_" + uuid);
			sqlUser.setPassword("pass_" + uuid);
			sqlUserRepository.save(sqlUser);
		}
	}
}