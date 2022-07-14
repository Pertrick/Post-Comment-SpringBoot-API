package com.myblog.BlogRestApi.controllers;

import com.myblog.BlogRestApi.domain.User;
import com.myblog.BlogRestApi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }

    @GetMapping(value = "")
    public List<User> showAllUser(){
        return userService.getAllUser();
    }

    @GetMapping(value = "/{id}")
    public User showUser(@PathVariable("id") Integer id){
        return userService.getUser(id);
    }

    @PutMapping(value="/{id}")
    public User updateUser(@RequestBody User user, @PathVariable("id") Integer id){
        return userService.updateUser(user, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
         userService.deleteUser(id);
    }
}
