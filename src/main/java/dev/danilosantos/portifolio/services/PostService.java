package dev.danilosantos.portifolio.services;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.danilosantos.portifolio.dto.PostDTO;
import dev.danilosantos.portifolio.entities.Post;
import dev.danilosantos.portifolio.repositories.PostRepository;
import dev.danilosantos.portifolio.repositories.UserRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	public List<Post> findAll() {
		return repository.findAll();
	}
	
	public Post findById(Long id) {
		Optional<Post> obj = repository.findById(id);
		return obj.get();
	}
	
	public PostDTO insert(PostDTO obj) {
		Post entity = new Post();
		copyDtoToEntity(obj, entity);
		entity = repository.save(entity);
		return new PostDTO(entity);
	}
	
	private void copyDtoToEntity(PostDTO dto, Post entity) {
		entity.setId(dto.getId());
		entity.setTitle(dto.getTitle());
		entity.setBody(dto.getBody());
		entity.setMoment(Instant.now());
		userRepository.findById(dto.getUser().getId()).ifPresent(user -> entity.setUser(user));
	}
}
