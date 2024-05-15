package cl.inadvance.prueba_inadvance.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class UserEntityTest {
	private static UserEntity user;
	
	@BeforeAll
	public static void setUserEntity() {
		user = new UserEntity();
		user.setId(UUID.randomUUID().toString());
		user.setName("pablo");
		user.setEmail("pablo@gmail.com");
		user.setPassword("pablo");
	}
	
	@Test
	public void testUserEntity() {
		assertEquals("pablo", user.getName());
		assertEquals("pablo@gmail.com", user.getEmail());
		assertEquals("pablo", user.getPassword());
	}
}
