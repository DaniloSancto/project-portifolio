package dev.danilosantos.portifolio.dto;

import java.io.Serializable;
import java.time.Instant;

import dev.danilosantos.portifolio.entities.Post;

public class PostDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String body;
	private Instant moment;
	private UserDTO user;
	
	public PostDTO() {}
	
	public PostDTO(Long id, String title, String body, Instant moment, UserDTO user) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.moment = moment;
		this.setUser(user);
	}
	
	public PostDTO(Post entity) {
		id = entity.getId();
		title = entity.getTitle();
		body = entity.getBody();
		moment = entity.getMoment();
		setUser(new UserDTO(entity.getUser()));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
