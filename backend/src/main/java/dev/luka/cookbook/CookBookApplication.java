package dev.luka.cookbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"dev.luka.cookbook.domain.repository"})
public class CookBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookBookApplication.class, args);
	}

}
