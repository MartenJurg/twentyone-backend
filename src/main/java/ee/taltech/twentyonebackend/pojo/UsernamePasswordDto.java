package ee.taltech.twentyonebackend.pojo;

public class UsernamePasswordDto {

    String username;
    String password;

    public UsernamePasswordDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
