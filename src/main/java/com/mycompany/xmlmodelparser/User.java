package com.mycompany.xmlmodelparser;

public class User {
  
  private String id;
  private String firstname;
  private String lastname;
  private String email;
  private String password;

  public User(){
    this("", "", "", "");
  }
  public User(String firstname, String lastname, String email, String password){
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.password = password;
  }

  public void setId(String id){
    this.id = id;
  }

  public String getId(){
    return this.id;
  }
  public void setFirstname(String firstname){
    this.firstname = firstname;
  }
  public String getFirstname(){
    return this.firstname;
  }
  public void setLastname(String lastname){
     this.lastname = lastname;
  }
  public String getLastname(){
    return this.lastname;
  }
  public void setEmail(String email){
     this.email = email;
  }
  public String getEmail(){
    return this.email;
  }
  public void setPassword(String password){
     this.password = password;
  }
  public String getPassword(){
    return this.password;
  }
}