package com.TCPGroup.project.Services;

import com.TCPGroup.project.Models.User;
import com.TCPGroup.project.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository=userRepository;
    }

    public List<User> getAllUsers(){
        return this.userRepository.findAll();
    }

    public User getById(Integer id){
        return this.userRepository.getById(id);
    }

    public User authenticateUser(User userToAuthenticate) {
        return userRepository.findByUsernameAndPassword(userToAuthenticate.getUsername(), userToAuthenticate.getPassword());
    }

    public User createUser(User user){
        System.out.println(user);
        return userRepository.save(user);
    }


}