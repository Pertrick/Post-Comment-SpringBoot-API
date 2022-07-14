package com.myblog.BlogRestApi.services;

import com.myblog.BlogRestApi.domain.User;
import com.myblog.BlogRestApi.exception.ResourceNotFoundException;
import com.myblog.BlogRestApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUser(Integer id){
        return userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No User found with id="+ id)
        );
    }

    public User updateUser(User user, Integer id){
        userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No User found with id="+ id)
        );
        return userRepository.save(user);
    }

    public void deleteUser(Integer id){
        User user = userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No User found with id="+ id)
        );

        userRepository.deleteById(user.getId());
    }
}
