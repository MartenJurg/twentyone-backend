package ee.taltech.twentyonebackend.service;

import ee.taltech.twentyonebackend.exception.UserNotFoundException;
import ee.taltech.twentyonebackend.security.model.User;
import ee.taltech.twentyonebackend.security.pojo.UserDto;
import ee.taltech.twentyonebackend.repository.UserRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

@Service
public class UserService {

    @Resource
    UserRepository userRepository;

    public UserDto getByUsername(String username) throws UserNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user.toString().length() <= 0) {
            throw new UsernameNotFoundException(format("username not found: %s", username));
        }


        return new UserDto(user);
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<User> getByName(String name) {
        return userRepository.findByName(name);
    }

    public User getById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}