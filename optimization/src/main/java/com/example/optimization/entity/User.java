package com.example.optimization.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Table(name = "User_Table")
public class User{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String first_name;
  private int age;
  private String gender;
  private String adhar_number;
  private String phone_number;
  
  
  @Override
  public String toString() {
    return "User [id=" + id + ", first_name=" + first_name + ", age=" + age + ", gender=" + gender + ", adhar_number="
        + adhar_number + ", phone_number=" + phone_number + "]";
  }
  public User(int id, String first_name, int age, String gender, String adhar_number, String phone_number) {
    super();
    this.id = id;
    this.first_name = first_name;
    this.age = age;
    this.gender = gender;
    this.adhar_number = adhar_number;
    this.phone_number = phone_number;
  }
  
 
  public User() {
    super();
    // TODO Auto-generated constructor stub
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getFirst_name() {
    return first_name;
  }
  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public String getGender() {
    return gender;
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public String getAdhar_number() {
    return adhar_number;
  }
  public void setAdhar_number(String adhar_number) {
    this.adhar_number = adhar_number;
  }
  public String getPhone_number() {
    return phone_number;
  }
  public void setPhone_number(String phone_number) {
    this.phone_number = phone_number;
  }
 
 
  

}
