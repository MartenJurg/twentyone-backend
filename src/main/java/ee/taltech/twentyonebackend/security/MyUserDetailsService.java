package ee.taltech.twentyonebackend.security;

import ee.taltech.twentyonebackend.pojo.RoleName;
import ee.taltech.twentyonebackend.repository.UserRepository;
import ee.taltech.twentyonebackend.security.model.User;
import ee.taltech.twentyonebackend.security.pojo.MyUserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.String.format;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user.toString().length() <= 0) {
            throw new UsernameNotFoundException(format("username not found: %s", username));
        }
        return new MyUserDto(user.getUsername(), user.getPassword(), getAuthorities(user), user.getRoleName(), user.getId());
    }


    private List<SimpleGrantedAuthority> getAuthorities(User user) {
        return getRoles(user)
                .map(RoleName::toSpringRole)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    /**
     * if user is admin, then they get all the roles in application
     */
    private Stream<RoleName> getRoles(User user) {
        if (user.getRoleName().equals(RoleName.ADMIN)) {
            return Arrays.stream(RoleName.values());
        }
        return Stream.of(user.getRoleName());
    }
}
