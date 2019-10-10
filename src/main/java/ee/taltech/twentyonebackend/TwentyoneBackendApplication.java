package ee.taltech.twentyonebackend;

import ee.taltech.twentyonebackend.model.User;
import ee.taltech.twentyonebackend.repository.UsersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TwentyoneBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwentyoneBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner initUsers(UsersRepository usersRepository) {
		return (args) -> {
			List<User> users = Arrays.asList(
					new User("matu1"),
					new User("matu2"),
					new User("matu3"),
					new User("matu4"),
					new User("matu5"),
					new User("matu6"),
					new User("matu7"),
					new User("matu8"),
					new User("matu9"),
					new User("matu10")
			);
			usersRepository.saveAll(users);
		};
	}
}
