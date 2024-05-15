package cl.inadvance.prueba_inadvance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.inadvance.prueba_inadvance.dto.InAdvanceRequest;
import cl.inadvance.prueba_inadvance.entities.UserEntity;
import cl.inadvance.prueba_inadvance.services.UserService;
import cl.inadvance.prueba_inadvance.validations.RequestBodyException;
import jakarta.validation.Valid;

@RestController
@Validated
public class InAdvanceController {
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/create-user")
	public ResponseEntity<Object> createUser(@Valid @RequestBody(required = false) InAdvanceRequest body) {
		if(body == null) {
			throw new RequestBodyException(null);
		}
		
		UserEntity user = userService.saveUser(body);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(user);
	}
}
