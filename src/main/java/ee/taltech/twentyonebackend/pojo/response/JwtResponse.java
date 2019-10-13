package ee.taltech.twentyonebackend.pojo.response;

public class JwtResponse {
	private boolean access;
	private String username;

	public JwtResponse(String username, boolean access) {
		this.access = access;
		this.username = username;

	}

	public boolean getAccess() {
		return access;
	}

	public void setAccess(boolean access) {
		this.access = access;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}