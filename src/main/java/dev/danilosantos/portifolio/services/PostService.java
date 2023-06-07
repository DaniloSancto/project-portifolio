package dev.danilosantos.portifolio.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.danilosantos.portifolio.dto.PostDTO;
import dev.danilosantos.portifolio.dto.PostInsertDTO;
import dev.danilosantos.portifolio.entities.Post;
import dev.danilosantos.portifolio.repositories.PostRepository;
import dev.danilosantos.portifolio.repositories.UserRepository;
import dev.danilosantos.portifolio.services.exceptions.ResourceNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<PostDTO> findAll() {
		List<Post> list = repository.findAll();
		return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}
	
	public PostDTO findById(Long id) {
		Optional<Post> obj = repository.findById(id);
		Post entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new PostDTO(entity);
	}
	
	public PostDTO insert(PostInsertDTO obj) {
		Post entity = new Post();
		copyDtoToEntity(obj, entity);
		entity = repository.save(entity);
		return new PostDTO(entity);
	}
	
	private void copyDtoToEntity(PostInsertDTO dto, Post entity) {
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setBody(dto.getBody());
		entity.setMoment(Instant.now());
		try {
			userRepository.findById(dto.getUser().getId()).ifPresentOrElse(user -> entity.setUser(user), null);
		}
		catch(NullPointerException e) {
			throw new ResourceNotFoundException("User don't exist. " + e.getMessage());
		}
	}
}
