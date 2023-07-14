package dev.danilosantos.portifolio.dto;

import dev.danilosantos.portifolio.services.validation.UserInsertValid;

@UserInsertValid
public class AuthRegisterDTO extends UserDTO {
	private static final long serialVersionUID = 1L;
	
	private String password;

	public AuthRegisterDTO() {
		super();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}