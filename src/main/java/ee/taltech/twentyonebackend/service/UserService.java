package ee.taltech.twentyonebackend.service;

import ee.taltech.twentyonebackend.exception.UserNotFoundException;
import ee.taltech.twentyonebackend.exception.UserValidationException;
import ee.taltech.twentyonebackend.model.User;
import ee.taltech.twentyonebackend.pojo.UserDto;
import ee.taltech.twentyonebackend.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Resource
    UserRepository userRepository;

    public UserDto getByUsername(String username) throws UserNotFoundException {

        User user = userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);

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