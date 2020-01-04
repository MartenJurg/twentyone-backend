package ee.taltech.twentyonebackend;

import ee.taltech.twentyonebackend.pojo.RoleName;
import ee.taltech.twentyonebackend.security.model.User;
import ee.taltech.twentyonebackend.service.UserService;
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
	public CommandLineRunner initUser(UserService userservice) {
		return (args) -> {
			 User user = new User(
			 		"root",
					 "admin",
					 "admin@hotmail.com",
					 "admin",
					 RoleName.ROLE_ADMIN
			 );
			 userservice.save(user);
		};
	}
}
