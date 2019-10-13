package ee.taltech.twentyonebackend.pojo;

import ee.taltech.twentyonebackend.service.RoleService;
import ee.taltech.twentyonebackend.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class Authenticator {

    @Resource
    UserService userService;

    @Resource
    RoleService roleService;

    public Authenticator() {
    }

    public boolean authenticate(UsernamePasswordDto usernamePasswordDto) {
        String username = usernamePasswordDto.getUsername();
        String password = usernamePasswordDto.getPassword();

        // do the magic and authenticate.
        return true;
    }

}
