package ee.taltech.twentyonebackend.controller;

import ee.taltech.twentyonebackend.model.Role;
import ee.taltech.twentyonebackend.model.RoleName;
import ee.taltech.twentyonebackend.model.User;
import ee.taltech.twentyonebackend.pojo.UsernamePasswordDto;
import ee.taltech.twentyonebackend.pojo.Authenticator;
import ee.taltech.twentyonebackend.pojo.request.LoginForm;
import ee.taltech.twentyonebackend.pojo.request.SignUpForm;
import ee.taltech.twentyonebackend.pojo.response.JwtResponse;
import ee.taltech.twentyonebackend.pojo.response.ResponseMessage;
import ee.taltech.twentyonebackend.repository.RoleRepository;
import ee.taltech.twentyonebackend.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Resource
	Authenticator authenticator;

	@Resource
	UserRepository userRepository;

	@Resource
	RoleRepository roleRepository;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {
		boolean authentication = authenticator.authenticate(
				new UsernamePasswordDto(loginRequest.getUsername(), loginRequest.getPassword())
		);

		return ResponseEntity.ok(new JwtResponse(loginRequest.getUsername(), authentication));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				signUpRequest.getPassword());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			case "pm":
				Role pmRole = roleRepository.findByName(RoleName.ROLE_PM)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(pmRole);

				break;
			default:
				Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setRoles(roles);
		userRepository.save(user);

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
}