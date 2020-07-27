package com.mycompany.xmlmodelparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AccountHandler extends DefaultHandler {

  private static final String ACCOUNT = "account";
  private static final String USERID = "userid";
  private static final String ACCOUNTBALANCE = "accountbalance";
  private static final String CREATEDAT = "createdat";

  public List<Account> accounts;
  public String currentValue;
  public Account currentAccount;

  @Override
  public void characters(char[] ch, int start, int length) throws SAXException {
    currentValue = new String(ch, start, length);
  }

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    switch (qName) {
      case ACCOUNT: {
        accounts.add(currentAccount);
        break;
      }
      case USERID: {
        currentAccount.setUserId(currentValue);
        break;
      }
      case ACCOUNTBALANCE: {
        currentAccount.setAccountBalance(currentValue);
        break;
      }
      case CREATEDAT: {
        currentAccount.setcreatedat(currentValue);
        break;
      }
    }
  }

  @Override
  public void startDocument() throws SAXException {
    accounts = new ArrayList<>();
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
    if (qName == ACCOUNT) {
        currentAccount = new Account();
        String id = attributes.getValue("id");
        currentAccount.setId(id);
    }
  }

  public List<Account> getAllAccounts(){
    return accounts;
  }


  public Account findAccountById(String id) throws Exception {
    Account account =  accounts.stream()
       .filter(curUser -> curUser.getId().equals(id))
       .findFirst()
       .orElse(null);
       
      if(!(account instanceof Account)){
        throw new Exception("No Account with that id found");
      }
      return account;
  }

  public List<Account> findUserAccounts(String userid){
    return accounts.stream()
      .filter(account -> account.getUserId().equals(userid))
      .collect(Collectors.toList());
  }
}