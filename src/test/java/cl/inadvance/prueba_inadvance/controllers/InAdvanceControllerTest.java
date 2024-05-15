package cl.inadvance.prueba_inadvance.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import cl.inadvance.prueba_inadvance.services.UserService;

@WebMvcTest(InAdvanceController.class)
@AutoConfigureMockMvc
public class InAdvanceControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	public void testInAdvanceController() throws Exception {
		mockMvc.perform(post("/create-user")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest());
	}
}
