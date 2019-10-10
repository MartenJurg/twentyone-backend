package ee.taltech.twentyonebackend.controller;

import ee.taltech.twentyonebackend.model.User;
import ee.taltech.twentyonebackend.pojo.UserDto;
import ee.taltech.twentyonebackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/users")
public class UserController {

    @Resource
    private UserService userService;


    @GetMapping
    public  List<User> users() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public UserDto saveUser(@RequestBody UserDto userDto) {
        return userService.createNewUser(userDto);
    }
}
