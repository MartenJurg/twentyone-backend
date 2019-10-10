package ee.taltech.twentyonebackend.service;


import ee.taltech.twentyonebackend.exception.UserNotFoundException;
import ee.taltech.twentyonebackend.exception.UserValidationException;
import ee.taltech.twentyonebackend.model.User;
import ee.taltech.twentyonebackend.pojo.UserDto;
import ee.taltech.twentyonebackend.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    public List<User> getByName(String name) {
        return usersRepository.findByName(name);
    }

    public User getById(Long id) {
        return usersRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    public UserDto createNewUser(UserDto userDto) {
        User user = new User(userDto);
        if (user.getName() == null) {
            throw new UserValidationException();
        }
        return new UserDto(usersRepository.save(user));
    }
}
