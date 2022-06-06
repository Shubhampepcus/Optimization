package com.example.optimization.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.example.optimization.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/")
  public ArrayList<User> getUsers() {
    long startTime = System.nanoTime();
    ArrayList<User> userList = userService.getAllUsers();
    long endTime = System.nanoTime();
    System.out.println(endTime - startTime);
    return userList;
  }

  @PostMapping("/")
  public User saveUser(@RequestBody User user) {
    return userService.saveUser(user);

  }

  @DeleteMapping("/")
  public User deleteUser(@RequestParam Integer id) {
    return userService.deleteUser(id);
  }

  @PatchMapping("/")
  public ArrayList<User> updateUser(@RequestParam Integer id, @RequestBody User user) {
    return userService.updateUser(user, id);
  }

  @GetMapping("/sort")
  public List<User> sortUser() {
    return userService.sortAllUsers();
  }

}
