package com.example.optimization.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.optimization.entity.User;
import com.example.optimization.service.HashMapService;
import com.example.optimization.service.TreeMapService;

@RestController
@RequestMapping("/usersTreeMap")
public class TreeMapController {

  @Autowired
  private TreeMapService treeMapService;

  @GetMapping("/")
  public Map<Integer, User> getUsers() {
    long startTime = System.nanoTime();
    Map<Integer, User> userMap = treeMapService.getAllUsers();
    long endTime = System.nanoTime();
    System.out.println(endTime - startTime);
    return userMap;
  }

  @DeleteMapping("/")
  public User deleteUser(@RequestParam Integer id) {
    return treeMapService.deleteUser(id);
  }

  @PatchMapping("/")
  public Map<Integer, User> updateUser(@RequestParam Integer id, @RequestBody User user) {
    return treeMapService.updateUser(user, id);
  }

  @GetMapping("/sort")
  public Map<Integer, User> sortUser() {
    return treeMapService.sortUser();
  }
}
