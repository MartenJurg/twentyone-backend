package ee.taltech.twentyonebackend.pojo.response;

public class JwtResponse {
	private boolean access;
	private String username;
	private String rolename;

	public JwtResponse(String username, boolean access,String rolename) {
		this.access = access;
		this.username = username;
		this.rolename = rolename;
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

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
