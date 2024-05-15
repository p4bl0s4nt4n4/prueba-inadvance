package cl.inadvance.prueba_inadvance.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class InAdvanceRequest {
	@NotBlank(message = "name no puede estar en blanco")
	private String name;
	@NotBlank(message = "email no puede estar en blanco")
	@Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "formato incorrecto")
	private String email;
	@NotBlank(message = "password no puede estar en blanco")
	private String password;
	@Valid
	@NotEmpty(message = "phones no puede estar en blanco")
	@Size(min = 1, message = "Debe haber al menos un elemento en phones")
	private List<InAdvancePhone> phones = new ArrayList<InAdvancePhone>();
	
	public InAdvanceRequest() {}

	public InAdvanceRequest(String name, String email, String password, List<InAdvancePhone> phones) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.phones = phones;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<InAdvancePhone> getPhones() {
		return phones;
	}

	public void setPhones(List<InAdvancePhone> phones) {
		this.phones = phones;
	}
}
