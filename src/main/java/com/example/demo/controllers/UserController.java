package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public ArrayList<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping()
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping(path="/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id){
        return userService.findById(id);
    }

    @GetMapping(path="priority")
    public ArrayList<User> getUserByPriority(@RequestParam("priority") Integer priority){
        return userService.findByPriority(priority);
    }

    @GetMapping(path="name")
    public ArrayList<User> getUserByNombre(@RequestParam String name){
        return userService.findByNombre(name);
    }

    @GetMapping(path="email")
    public ArrayList<User> getUserByEmail(@RequestParam String email){
        return userService.findByEmail(email);
    }

    @DeleteMapping(path="{id}")
    public String deleteUser(@PathVariable("id") Long id){
        if(userService.deleteUser(id)){
            return "Usuario se ha eliminado";
        }
        return "No se pudo eliminar el usuario";
    }
}
