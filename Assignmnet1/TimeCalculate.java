package Optimization;

import java.sql.Time;
import java.time.Duration;
import java.time.Instant;

public class TimeCalculate {

  public long factorial(long number) {
    return number == 1 ? 1 : number * factorial(number - 1);
  }

  long factorialForLoop(long number) {
    long result = 1;
    for (; number > 0; number--) {
      result *= number;
    }
    return result;
  }

  void calculateLoops() {
    TimeCalculate timeCalculate = new TimeCalculate();
    long startTime = System.nanoTime();
    System.out.println(timeCalculate.factorial(10000));
    long stopTime = System.nanoTime();
    System.out.println(stopTime - startTime);

    startTime = System.nanoTime();
    System.out.println(timeCalculate.factorialForLoop(10000));
    stopTime = System.nanoTime();
    System.out.println(stopTime - startTime);
  }

  String operatorBlocks(int x, int y, int z) {
    String result = null;
    ;
    if (x == y && x == z) {
      result = "succeced";
    } else {
      result = "failed";
    }
    return result;
  }

  String ifblocks(int x, int y, int z) {
    String result = null;

    if (x == y) {
      if (x == z) {
        result = "succeced";
      }
    } else {
      result = "failed";
    }
    return result;
  }

  void calculateIfblocks() {
    TimeCalculate timeCalculate = new TimeCalculate();
    long startTime = System.nanoTime();
    System.out.println(timeCalculate.operatorBlocks(10, 20, 30));
    long stopTime = System.nanoTime();
    System.out.println(stopTime - startTime);

    startTime = System.nanoTime();
    System.out.println(timeCalculate.ifblocks(10, 20, 30));
    stopTime = System.nanoTime();
    System.out.println(stopTime - startTime);
  }

  void stringCalculate() {
    // String Concatentation
    String profilePictureUrl = null;
    long startTime = System.nanoTime();
    int userId;
    int NUM_ITERATIONS = 10;
    String PROFILE_PICTURE_URL_BASE = "Profile";
    String PROFILE_PICTURE_URL_EXTENSION = "Jpg";
    for (userId = 0; userId < NUM_ITERATIONS; userId++) {
      profilePictureUrl = PROFILE_PICTURE_URL_BASE + userId + PROFILE_PICTURE_URL_EXTENSION;
    }
    long stopTime = System.nanoTime();
    System.out.println("String Concatentation: " + (stopTime - startTime) + "ms" + "   " + profilePictureUrl);
  }

  void stringBuilderconcate() {
    // StringBuilder --FASTER CODE---
    long startTime = System.nanoTime();
    int userId;
    int NUM_ITERATIONS = 10;
    String profilePictureUrl = null;
    StringBuilder PROFILE_PICTURE_URL_BASE = new StringBuilder("Profile");
    StringBuilder PROFILE_PICTURE_URL_EXTENSION = new StringBuilder("Jpg");
    for (userId = 0; userId < NUM_ITERATIONS; userId++) {
      StringBuilder sb = new StringBuilder(PROFILE_PICTURE_URL_BASE);
      sb.append(userId);
      sb.append(PROFILE_PICTURE_URL_EXTENSION);

      profilePictureUrl = sb.toString();
    }
    long stopTime = System.nanoTime();
    System.out.println("StringBuilder: " + (stopTime - startTime) + "ms" + "   " + profilePictureUrl);
  }

  void calculateConcatinationTime() {
    TimeCalculate timeCalculate = new TimeCalculate();
    timeCalculate.stringCalculate();
    timeCalculate.stringBuilderconcate();
  }

  public static void main(String[] args) {
    TimeCalculate timeCalculate = new TimeCalculate();
    timeCalculate.calculateLoops();
    timeCalculate.calculateIfblocks();
    timeCalculate.calculateConcatinationTime();

  }
}
