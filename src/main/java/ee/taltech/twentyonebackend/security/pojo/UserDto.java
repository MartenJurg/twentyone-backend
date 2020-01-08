package ee.taltech.twentyonebackend.security.pojo;

import ee.taltech.twentyonebackend.pojo.RoleName;
import ee.taltech.twentyonebackend.security.model.User;

public class UserDto {

    private Long id;
    private String name;
    private String username;
    private String password;
    private String email;
    private RoleName roleName;

    public UserDto() {
    }

    public UserDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roleName = user.getRoleName();
    }

    public UserDto(Long id, String username, String password, RoleName roleName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roleName = roleName;
    }

    public String getName() {
        return name;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
