package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    
    public ArrayList<User> getUsers(){
        return (ArrayList<User>) userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public ArrayList<User> findByPriority(Integer priority){
        return userRepository.findByPriority(priority);
    }

    public ArrayList<User> findByNombre(String nombre){
        return userRepository.findByNombre(nombre);
    }


    public ArrayList<User> findByEmail(String email){
        return userRepository.findByEmail(email);
    }


    public boolean deleteUser(Long id){
        try{
            userRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
