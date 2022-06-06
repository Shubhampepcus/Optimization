package com.example.optimization.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.optimization.entity.User;
import com.example.optimization.service.SetService;
import com.example.optimization.service.UserService;

@RestController
@RequestMapping("/usersSet")
public class SetController {
  @Autowired
  private SetService setService;

  @GetMapping("/")
  public Set<User> getUsers() {
    Set<User> userSet = setService.getAllUsers();
    return userSet;
  }

  @PostMapping("/")
  public User saveUser(@RequestBody User user) {
    return setService.saveUser(user);

  }

  @DeleteMapping("/")
  public User deleteUser(@RequestParam Integer id) {
    return setService.deleteUser(id);
  }

  @GetMapping("/sort")
  public Set<User> sortUser() {
    return setService.sortAllUsers();
  }

}
