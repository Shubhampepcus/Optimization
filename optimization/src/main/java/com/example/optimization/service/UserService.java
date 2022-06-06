package com.example.optimization.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.optimization.repository.UserRepository;
import com.example.optimization.entity.User;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;
  ArrayList<User> userList;

  public ArrayList<User> getAllUsers() {
    long startTime = System.nanoTime();
    userList = (ArrayList<User>) userRepository.findAll();
    long endTime = System.nanoTime();
    System.out.println("fetch----time");
    System.out.println(endTime - startTime);
    return userList;
  }

  public User saveUser(User user) {
    long startTime = System.nanoTime();
    userList.add(5000, user);
    long endTime = System.nanoTime();
    System.out.println(endTime - startTime);
    System.out.println(userList.get(0));
    // TODO Auto-generated method stub
    return user;
  }

  public User deleteUser(Integer id) {
    User searchedUser = null;
    long startSearchTime = System.nanoTime();
    for (User user : userList) {
      if (user.getId() == id) {
        searchedUser = user;
      }
    }
    long endSearchTime = System.nanoTime();
    System.out.println("time for search");
    System.out.println(endSearchTime - startSearchTime);

    long startTime = System.nanoTime();
    Boolean user = userList.remove(searchedUser);
    long endTime = System.nanoTime();
    System.out.println("delete Time");
    System.out.println(endTime - startTime);
    return searchedUser;
  }

  public ArrayList<User> updateUser(User user, Integer id) {
    User searchedUser = null;
    long startTime = System.nanoTime();
    for (User existingUser : userList) {
      if (existingUser.getId() == id) {
        searchedUser = existingUser;
        searchedUser.setFirst_name(user.getFirst_name());
        searchedUser.setPhone_number(user.getPhone_number());
        searchedUser.setGender(user.getPhone_number());
        searchedUser.setAge(user.getAge());
        searchedUser.setAdhar_number(user.getAdhar_number());
        User updated = userList.set(existingUser.getId() - 1, searchedUser);
        System.out.println("dta successfully updated");
        System.out.println(updated);
      } else {
        System.out.println("updation unsuccess");
      }

    }
    long endTime = System.nanoTime();
    System.out.println("updation time");
    System.out.println(endTime - startTime);
    return userList;
  }

  public List<User> sortAllUsers() {
    User user;
    long startTime = System.nanoTime();
    List<User> sortedList = userList.stream().sorted(Comparator.comparing(User::getId)).collect(Collectors.toList());
    long endTime = System.nanoTime();
    System.out.println("Sort---Time");
    System.out.println(endTime - startTime);

    return sortedList;
  }

}
