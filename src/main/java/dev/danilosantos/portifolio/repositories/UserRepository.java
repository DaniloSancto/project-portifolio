package dev.danilosantos.portifolio.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.danilosantos.portifolio.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByEmail(String email);
}
