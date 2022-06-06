package com.example.optimization.repository;

import java.util.HashSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.optimization.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
  public List<User>findAll();  
  

}
