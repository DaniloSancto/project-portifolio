package dev.danilosantos.portifolio.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import dev.danilosantos.portifolio.entities.Post;
import dev.danilosantos.portifolio.entities.User;
import dev.danilosantos.portifolio.repositories.PostRepository;
import dev.danilosantos.portifolio.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = new User(null, "Cleiton", "cleiton@gmail.com", "123456");
		User user2 = new User(null, "Felipe", "felipe@gmail.com", "123456");
		
		Post post1 = new Post(null, "My personal work", "Its based on cinema things", Instant.parse("2023-04-04T21:53:07Z"));
		Post post2 = new Post(null, "A job that i made", "Its a website to my friend from Mexico", Instant.parse("2023-04-10T13:22:35Z"));
		
		userRepository.saveAll(Arrays.asList(user1, user2));
		postRepository.saveAll(Arrays.asList(post1, post2));
		
	}
}
