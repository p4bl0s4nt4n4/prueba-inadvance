package cl.inadvance.prueba_inadvance.dto;

import jakarta.validation.constraints.NotBlank;

public class InAdvancePhone {
	@NotBlank(message = "number no puede estar en blanco")
	private String number;
	@NotBlank(message = "citycode no puede estar en blanco")
	private String citycode;
	@NotBlank(message = "countrycode no puede estar en blanco")
	private String countrycode;
	
	public InAdvancePhone() {}

	public InAdvancePhone(String number, String citycode, String countrycode) {
		this.number = number;
		this.citycode = citycode;
		this.countrycode = countrycode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getCountrycode() {
		return countrycode;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}
	
	
}
