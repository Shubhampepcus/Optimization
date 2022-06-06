package Optimization;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ArrayListDuplicates {
  ArrayList<Integer> list = new ArrayList<>();

  public ArrayList<Integer> initializeList(){
    for(int i = 0; i<=30; i++){
      int number = (int) (i * Math.random());
      list.add(number);
    }
    return list;
  }

  public HashSet<Integer> find_duplicates(){
    HashSet set = new HashSet();
    HashSet<Integer> duplicateElements = new HashSet();
    for(Integer i : list) {
      if (set.add(i)) {
        set.add(i);
      } else {
        duplicateElements.add(i);
      }
    }
    return duplicateElements;
  }

  public static void main(String[] args) {
    ArrayListDuplicates arrayListDuplicates = new ArrayListDuplicates();

    System.out.println(arrayListDuplicates.initializeList());
    System.out.println("duplicate bumbers========"+arrayListDuplicates.find_duplicates());
    List<Integer> numerList = new ArrayList<>();
    numerList.add(5);
    numerList.add(3);
    numerList.add(10);
    numerList.add(11);
    numerList.add(9);
    System.out.println("Missing Number============="+findMissingNumbers(numerList));
  }

  public static List <Integer> findMissingNumbers (List<Integer> numbers) {
    List<Integer> missingNumbers = new ArrayList <>();
    numbers = numbers.stream().sorted().collect(Collectors.toList());
    for (int i=numbers.get(0); i <= numbers.get(numbers.size()-1); i++) {
      if (!numbers.contains(i)) {
        missingNumbers.add(i);
      }
    }
    return missingNumbers;
  }
}
