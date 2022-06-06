package com.example.optimization.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.optimization.repository.UserRepository;
import com.example.optimization.entity.User;

@Service
public class SetService {
  @Autowired
  private UserRepository userRepository;
  Set<User> userSet = new HashSet<User>();

  public Set<User> getAllUsers() {
    List<User> userList = userRepository.findAll();
    long startTime = System.nanoTime();
    for (User user : userList) {
      userSet.add(user);
    }
    Iterator it = userSet.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }
    long endTime = System.nanoTime();
    System.out.println("fetch----time");
    System.out.println(endTime - startTime);
    return userSet;
  }

  public User saveUser(User user) {
    long startTime = System.nanoTime();
    userSet.add(user);
    long endTime = System.nanoTime();
    System.out.println(endTime - startTime);
    System.out.println(userSet);
    // TODO Auto-generated method stub
    return user;
  }

  public User deleteUser(Integer id) {
    User searchedUser = null;
    long startSearchTime = System.nanoTime();
    for (User user : userSet) {
      if (user.getId() == id) {
        searchedUser = user;
      }
    }

    long endSearchTime = System.nanoTime();
    System.out.println("time for search");
    System.out.println(endSearchTime - startSearchTime);

    long startTime = System.nanoTime();
    Boolean user = userSet.remove(searchedUser);
    long endTime = System.nanoTime();
    System.out.println("delete Time");
    System.out.println(endTime - startTime);
    return searchedUser;
  }

  public Set<User> sortAllUsers() {
    List<User> userList = userRepository.findAll();
    for (User user : userList) {
      userSet.add(user);
    }
    Iterator it = userSet.iterator();

    while (it.hasNext()) {
      System.out.println(it.next());
    }

    long startTime = System.nanoTime();
    List<User> sortedList = userSet.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
    TreeSet<User> tree_set = new TreeSet<>(userSet);
    long endTime = System.nanoTime();
    System.out.println("Sorting Time");
    System.out.println(endTime - startTime);
    return tree_set;
  }

}
