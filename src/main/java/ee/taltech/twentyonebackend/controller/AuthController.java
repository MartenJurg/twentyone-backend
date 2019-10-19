package ee.taltech.twentyonebackend.controller;

import ee.taltech.twentyonebackend.exception.AuthenticationFailedException;
import ee.taltech.twentyonebackend.model.UserData;
import ee.taltech.twentyonebackend.model.UserInventory;
import ee.taltech.twentyonebackend.pojo.RoleName;
import ee.taltech.twentyonebackend.model.User;
import ee.taltech.twentyonebackend.pojo.UsernamePasswordDto;
import ee.taltech.twentyonebackend.pojo.Authenticator;
import ee.taltech.twentyonebackend.pojo.request.LoginForm;
import ee.taltech.twentyonebackend.pojo.request.SignUpForm;
import ee.taltech.twentyonebackend.pojo.response.JwtResponse;
import ee.taltech.twentyonebackend.pojo.response.ResponseMessage;
import ee.taltech.twentyonebackend.service.UserDataService;
import ee.taltech.twentyonebackend.service.UserInventoryService;
import ee.taltech.twentyonebackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Resource
	Authenticator authenticator;

	@Resource
	UserDataService userDataService;

	@Resource
	UserInventoryService userInventoryService;

	@Resource
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@RequestBody LoginForm loginRequest) {
		boolean authentication = authenticator.authenticate(
				new UsernamePasswordDto(loginRequest.getUsername(), loginRequest.getPassword())
		);

		if (!authentication) {
		    throw  new AuthenticationFailedException();
        }

        // actually has to return authorities.
		return ResponseEntity.ok(new JwtResponse(loginRequest.getUsername(), authentication));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userService.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (userService.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}

		String strRole = signUpRequest.getRole();
		RoleName role ;

		switch (strRole) {
			case "admin":
				role = RoleName.ROLE_ADMIN;
				break;
			case "pm":
				role = RoleName.ROLE_PM;
				break;
			default:
				role = RoleName.ROLE_USER;
		}

		// Creating user's account
		User user = new User(signUpRequest.getName(), signUpRequest.getUsername(), signUpRequest.getEmail(),
				signUpRequest.getPassword(), role);
		userService.save(user);
		userDataService.save(new UserData(user.getUsername()));
		userInventoryService.save(new UserInventory(user.getUsername()));

		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
}