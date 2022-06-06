package com.example.optimization.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.optimization.repository.UserRepository;
import com.example.optimization.entity.User;

@Service
public class LinkedListService {
  @Autowired
  private UserRepository userRepository;
  LinkedList<User> userList = new LinkedList<>();

  public LinkedList<User> getAllUsers() {
    List<User> users = userRepository.findAll();
    long startTime = System.nanoTime();
    ListIterator<User> namesIterator = users.listIterator();
    while (namesIterator.hasNext()) {

      userList.add(namesIterator.next());
    }
    long endTime = System.nanoTime();
    System.out.println("fetch----time");
    System.out.println(endTime - startTime);
    return userList;
  }

  public User saveUser(User user) {
    long startTime = System.nanoTime();
    userList.add(49999, user);

    long endTime = System.nanoTime();
    System.out.println("Added in time");
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
    // User findeduser = userList.get(id);
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

  public LinkedList<User> updateUser(User user, Integer id) {
    User searchedUser = null;
    String result = null;
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
        result = "User SuccessFully Updated";
        System.out.println(updated);
      }

    }

    System.out.println(result);
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
