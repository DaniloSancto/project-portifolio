package dev.danilosantos.portifolio.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.danilosantos.portifolio.dto.UserDTO;
import dev.danilosantos.portifolio.dto.UserInsertDTO;
import dev.danilosantos.portifolio.entities.User;
import dev.danilosantos.portifolio.repositories.UserRepository;
import dev.danilosantos.portifolio.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		List<User> list = repository.findAll();
		return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new UserDTO(entity);
	}
	
	@Transactional
	public UserDTO insert(UserInsertDTO obj) {
		User entity = new User();
		copyDtoToEntity(obj, entity);
		entity.setPassword(passwordEncoder.encode(obj.getPassword()));
		entity = repository.save(entity);
		return new UserDTO(entity);
	}

	private void copyDtoToEntity(UserDTO dto, User entity) {
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
	}
}