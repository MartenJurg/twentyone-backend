package ee.taltech.twentyonebackend.controller;

import ee.taltech.twentyonebackend.model.User;
import ee.taltech.twentyonebackend.pojo.UserDto;
import ee.taltech.twentyonebackend.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
}
