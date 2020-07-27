package com.mycompany.xmlmodelparser;

public class Account {

  private String id;
  private String userid;
  private String accountbalance;
  private String type;
  private String createdat;

  public Account(){
    this("", "", "", "");
  }
  public Account(String userid, String accountbalance, String type, String createdat){
    this.userid = userid;
    this.accountbalance = accountbalance;
    this.type = type;
    this.createdat = createdat;
  }

  public void setId(String id){
    this.id = id;
  }
  public String getId(){
    return this.id;
  }
  public void setUserId(String userid){
    this.userid = userid;
  }
  public String getUserId(){
    return this.userid;
  }

  public String getAccountBalance(){
    return this.accountbalance;
  }

  public void setAccountBalance(String accountbalance){
    this.accountbalance = accountbalance;
  }

  public void setcreatedat(String createdat){
    this.createdat = createdat;
  }
  public String getcreatedat(){
    return this.createdat;
  }

  public String getType(){
    return this.type;
  }

  public void setType(String type){
    this.type = type;
  }
}