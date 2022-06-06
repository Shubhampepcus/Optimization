package com.example.optimization.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentSkipListMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.optimization.entity.User;
import com.example.optimization.repository.UserRepository;

@Service
public class TreeMapService {
  @Autowired
  private UserRepository userRepository;
  public TreeMap<Integer, User> userMap = new TreeMap<>();

  public Map<Integer, User> getAllUsers() {
    List<User> users;
    users = userRepository.findAll();
    long startTime = System.nanoTime();
    ListIterator<User> namesIterator = users.listIterator();
    while (namesIterator.hasNext()) {
      User user = namesIterator.next();
      userMap.put(user.getId(), user);
    }

    long endTime = System.nanoTime();
    System.out.println("fetch----time");
    System.out.println(endTime - startTime);
    return userMap;
  }

  public User saveUser(User user) {
    long startTime = System.nanoTime();
    userMap.put(user.getId(), user); // we can't put elements at specified index
                                     // in map this method will insert an
                                     // element to the last position.
    long endTime = System.nanoTime();
    System.out.println(endTime - startTime);
    System.out.println(userMap.get(user.getId()));
    return user;
  }

  public User deleteUser(Integer key) {
    User searchedUser = null;
    long startSearchTime = System.nanoTime();
    if (userMap.containsKey(key)) {
      searchedUser = userMap.get(key);
    }

    long endSearchTime = System.nanoTime();
    System.out.println("time for search");
    System.out.println(endSearchTime - startSearchTime);

    long startTime = System.nanoTime();
    Boolean user = userMap.remove(key, searchedUser);
    long endTime = System.nanoTime();
    System.out.println("delete Time");
    System.out.println(endTime - startTime);
    return searchedUser;
  }

  public Map<Integer, User> updateUser(User user, Integer key) {
    User searchedUser = null;
    long startSearchTime = System.nanoTime();
    if (userMap.containsKey(key)) {
      searchedUser = userMap.replace(key, user);
      System.out.println("user updated successfully");
    }

    long endSearchTime = System.nanoTime();
    System.out.println("time for update");
    System.out.println(endSearchTime - startSearchTime);
    return userMap;
  }

  public Map<Integer, User> sortUser() {
    User searchedUser = null;
    long startSearchTime = System.nanoTime();
    for (Entry<Integer, User> e : userMap.entrySet()) {
      System.out.println(e.getKey() + "-->" + e.getValue());
    }

    ArrayList<Integer> sortedList = new ArrayList<>(userMap.keySet());
    Collections.sort(sortedList);// Sorting the ArrayList

    System.out.println("\nPrinting the Alphabetically Sorted Keys");
    for (Integer s : sortedList) {
      System.out.println(s + "-->" + userMap.get(s));
    }

    long endSearchTime = System.nanoTime();
    System.out.println("time for sort");
    System.out.println(endSearchTime - startSearchTime);
    return userMap;
  }

}
