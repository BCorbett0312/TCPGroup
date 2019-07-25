package com.TCPGroup.project.Controllers;

import com.TCPGroup.project.Models.User;
import com.TCPGroup.project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {


    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService=userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id){
        return this.userService.getById(id);
    }

    @PostMapping("/users/auth")
    public User authenticateUser(@RequestBody User userToAuthenticate) {
        return this.userService.authenticateUser(userToAuthenticate);
    }

    @PostMapping("/users")
    public User createNewUser(@RequestBody User newUser){
        return this.userService.createUser(newUser);
    }

}
