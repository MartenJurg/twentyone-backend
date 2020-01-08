package ee.taltech.twentyonebackend.security.pojo;


import ee.taltech.twentyonebackend.pojo.RoleName;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import java.util.Collection;

/**
 * to have our own properties on session user
 * also to have clean imports as our model User and spring security User have same name "User"
 */
@Getter
public class MyUserDto extends User {


    private Long id;
    private RoleName role;

    public MyUserDto(String username, String password, Collection<? extends GrantedAuthority> authorities, RoleName role, Long id) {
        super(username, password, authorities);
        this.role = role;
        this.id = id;
    }

    /**
     * we are forced to override this constructor, however we don't use it
     */
    public MyUserDto(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}


