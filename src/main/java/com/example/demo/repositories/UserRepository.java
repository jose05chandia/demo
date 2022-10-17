package com.example.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    public abstract ArrayList<User>  findByPriority(Integer priority);
    public abstract ArrayList<User>  findByNombre(String nombre);
    public abstract ArrayList<User>  findByEmail(String email);
    
}
