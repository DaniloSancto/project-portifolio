package dev.danilosantos.portifolio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.danilosantos.portifolio.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
