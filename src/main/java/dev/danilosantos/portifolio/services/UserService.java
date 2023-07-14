package dev.danilosantos.portifolio.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.danilosantos.portifolio.dto.PostDTO;
import dev.danilosantos.portifolio.dto.UserDTO;
import dev.danilosantos.portifolio.entities.Post;
import dev.danilosantos.portifolio.entities.User;
import dev.danilosantos.portifolio.repositories.PostRepository;
import dev.danilosantos.portifolio.repositories.UserRepository;
import dev.danilosantos.portifolio.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	private UserRepository repository;

	private PostRepository postRepository;
	
	public UserService(UserRepository repository, PostRepository postRepository) {
		this.repository = repository;
		this.postRepository = postRepository;
	}

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
	
	@Transactional(readOnly = true)
	public List<PostDTO> findAllUserPosts(Long id) {
		Optional<User> obj = repository.findById(id);
		User entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		List<Post> list = postRepository.findAllUserPosts(entity.getId());
		return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}
}