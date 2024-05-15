package cl.inadvance.prueba_inadvance.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.inadvance.prueba_inadvance.dto.InAdvancePhone;
import cl.inadvance.prueba_inadvance.dto.InAdvanceRequest;
import cl.inadvance.prueba_inadvance.entities.PhoneEntity;
import cl.inadvance.prueba_inadvance.entities.UserEntity;
import cl.inadvance.prueba_inadvance.repositories.PhoneRepository;
import cl.inadvance.prueba_inadvance.repositories.UserRepository;
import cl.inadvance.prueba_inadvance.validations.UserExistException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PhoneRepository phoneRepository;
	
	public UserEntity saveUser(InAdvanceRequest param) {
		Optional<UserEntity> userExist = userRepository.findByEmail(param.getEmail());
		
		if (userExist.isPresent()) {
			throw new UserExistException("usuario existe");
		}
		
		UserEntity user = userRepository.save(new UserEntity(param.getName(), param.getEmail(), param.getPassword()));
		
		List<PhoneEntity> phones = new ArrayList<>();
		
		for(InAdvancePhone phone: param.getPhones()) {
			phones.add(new PhoneEntity(phone.getNumber(), phone.getCitycode(), phone.getCountrycode(), user));
		}
		
		phoneRepository.saveAll(phones);
		
		return user;
	}
}
