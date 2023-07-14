package dev.danilosantos.portifolio.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.danilosantos.portifolio.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
	
	@Query("SELECT p from Post p INNER JOIN User u on p.user.id = u.id where u.id = :userId")
	List<Post> findAllUserPosts(Long userId);
}
