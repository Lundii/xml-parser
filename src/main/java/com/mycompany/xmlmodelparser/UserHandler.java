package com.mycompany.xmlmodelparser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler {

  private static final String USER = "user";
  private static final String FIRSTNAME = "firstname";
  private static final String LASTNAME = "lastname";
  private static final String EMAIL = "email";
  private static final String PASSWORD = "password";

  public List<User> users;
  public String currentValue;
  public User currentUser;

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    currentValue = new String(ch, start, length);
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    switch (qName) {
      case USER: {
        users.add(currentUser);
        break;
      }
      case FIRSTNAME: {
        currentUser.setFirstname(currentValue);
        break;
      }
      case LASTNAME: {
        currentUser.setLastname(currentValue);
        break;
      }
      case EMAIL: {
        currentUser.setEmail(currentValue);
        break;
      }
      case PASSWORD: {
        currentUser.setPassword(currentValue);
        break;
      }
    }
  }

  @Override
  public void startDocument() throws SAXException {
    users = new ArrayList<>();
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    switch (qName) {
      case USER: {
        currentUser = new User();
        String id = attributes.getValue("id");
        currentUser.setId(id);
      }
    }
  }

  public List<User> getAllUsers() {
    return users;
  }

  public User findUserByEmail(String email) throws Exception {
   User user = users.stream()
      .filter(curUser -> curUser.getEmail().equals(email))
      .findAny()
      .orElse(null);
    
      if(!(user instanceof User)){
        throw new Exception("No User with that email found");
      }
      return user;
  }

  public User findUserById(String id) throws Exception {
    User user =  users.stream()
       .filter(curUser -> curUser.getId().equals(id))
       .findFirst()
       .orElse(null);
       
      if(!(user instanceof User)){
        throw new Exception("No User with that id found");
      }
      return user;
  }
}