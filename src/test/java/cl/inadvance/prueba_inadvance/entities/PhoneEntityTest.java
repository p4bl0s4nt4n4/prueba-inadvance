package cl.inadvance.prueba_inadvance.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PhoneEntityTest {
	private static PhoneEntity phone;
	private static UserEntity user;
	
	@BeforeAll
	private static void setEntities() {
		user = new UserEntity();
		user.setId(UUID.randomUUID().toString());
		user.setName("pablo");
		user.setEmail("pablo@gmail.com");
		user.setPassword("pablo");
		
		phone = new PhoneEntity();
		phone.setNumber("123456");
		phone.setCitycode("aaa");
		phone.setCountrycode("bbb");
		phone.setUser(user);
		
	}
	
	@Test
	public void testPhoneEntity() {
		assertEquals("123456", phone.getNumber());
		assertEquals("pablo", phone.getUser().getName());
	}
}
