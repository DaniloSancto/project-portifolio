package dev.danilosantos.portifolio.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.danilosantos.portifolio.dto.AuthRegisterDTO;
import dev.danilosantos.portifolio.dto.AuthRequestDTO;
import dev.danilosantos.portifolio.dto.AuthResponseDTO;
import dev.danilosantos.portifolio.services.AuthService;
import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/auth")
public class AuthController {
	
	private AuthService service;
	
	public AuthController(AuthService service) {
		this.service = service;
	}

	@PostMapping(value = "/register")
	public ResponseEntity<AuthResponseDTO> register(@Valid @RequestBody AuthRegisterDTO request) {
		return ResponseEntity.ok(service.register(request));
	}
	
	@PostMapping(value = "/login")
	public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO request) {
		return ResponseEntity.ok(service.login(request));
	}
	
}
