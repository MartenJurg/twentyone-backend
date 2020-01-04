package ee.taltech.twentyonebackend;

import ee.taltech.twentyonebackend.pojo.RoleName;
import ee.taltech.twentyonebackend.repository.UserRepository;
import ee.taltech.twentyonebackend.security.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class TwentyoneBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwentyoneBackendApplication.class, args);

	}

	@Bean
	public CommandLineRunner initUser(UserRepository userRepository) {
		return (args) -> {
			User user = new User(
					"admin1",
					"admin1",
					"admin@hotmail.com",
					"admin1",
					RoleName.ROLE_ADMIN
			);
			userRepository.save(user);
		};
	}

}
