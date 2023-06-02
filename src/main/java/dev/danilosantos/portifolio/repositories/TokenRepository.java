package dev.danilosantos.portifolio.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.danilosantos.portifolio.entities.Token;

public interface TokenRepository extends JpaRepository<Token, Long> {
	
	@Query("SELECT t from Token t INNER JOIN User u on t.user.id = u.id where u.id = :userId and (t.expired = false)")
	List<Token> findAllValidTokensByUser(Long userId);
	
	Optional<Token> findByToken(String token);
	
}
