package ee.taltech.twentyonebackend.pojo.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
	private String username;
	private String token;
	private String role;

	public UserResponse(String username,String token, String role) {
		this.username = username;
		this.token = token;
		this.role = role;
	}
}
