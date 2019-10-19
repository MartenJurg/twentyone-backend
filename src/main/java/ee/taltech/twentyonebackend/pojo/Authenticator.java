package ee.taltech.twentyonebackend.pojo;

import ee.taltech.twentyonebackend.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Authenticator {

    @Resource
    UserService userService;

    public Authenticator() {
    }

    public boolean authenticate(UsernamePasswordDto usernamePasswordDto) {
        String username = usernamePasswordDto.getUsername();
        String password = usernamePasswordDto.getPassword();
        UserDto user = userService.getByUsername(username);
        return (username.equals(user.getUsername()) && password.equals(user.getPassword()));
    }
}
