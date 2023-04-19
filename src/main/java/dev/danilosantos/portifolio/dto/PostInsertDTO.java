package dev.danilosantos.portifolio.dto;

import java.time.Instant;

import dev.danilosantos.portifolio.entities.Post;

public class PostInsertDTO extends PostDTO {
	private static final long serialVersionUID = 1L;
	
	private UserDTO user;
	
	public PostInsertDTO(Long id, String title, String body, Instant moment,UserDTO user) {
		super(id, title, body, moment);
		this.user = user;
	}
	
	public PostInsertDTO(Post entity) {
		super(entity);
		this.user = new UserDTO(entity.getUser());
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
