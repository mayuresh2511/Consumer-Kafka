package com.example.springKafka;

public class EmployeeDTO {

  private String firstName;
  private String lastName;
  private String city;
  private String email;
  private Integer mobileNumber;

  public EmployeeDTO(){}

  public EmployeeDTO(String firstName, String lastName, String city, String email, Integer mobileNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.city = city;
    this.email = email;
    this.mobileNumber = mobileNumber;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Integer getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(Integer mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  @Override
  public String toString() {
    return "EmployeeDTO{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        '}';
  }
}
