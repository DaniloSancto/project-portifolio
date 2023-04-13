package dev.danilosantos.portifolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.danilosantos.portifolio.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}
