
package com.mycompany.xmlmodelparser;

import java.io.File;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UserHandler userhandler = new UserHandler();
        AccountHandler accountHandler = new AccountHandler();

        try {
            
           URL url1 = MainClass.class.getResource("users.xml");
           URL url2 = MainClass.class.getResource("accounts.xml");
           File inputFile1 = new File(url1.getPath());
           File inputFile2 = new File(url2.getPath());
        
           SAXParserFactory factory = SAXParserFactory.newInstance();
           SAXParser saxParser = factory.newSAXParser();
           saxParser.parse(inputFile1, userhandler);     
           saxParser.parse(inputFile2, accountHandler);   
        } catch (Exception e) {
           e.printStackTrace();
        }

        try {
            User user = userhandler.findUserById("2");
            System.out.printf("%n ID: %s%n Firstname:  %s%n Lastname: %s%n Email: %s%n Accounts: ", 
                                user.getId(), 
                                user.getFirstname(), 
                                user.getLastname(), 
                                user.getEmail());

            List<Account> userAccounts = accountHandler.findUserAccounts(user.getId());

            for (Account account: userAccounts){
                System.out.printf("%n    ID: %s%n    AccountBalance: %s%n    CreatedAt: %s%n",
                                    account.getId(),
                                    account.getAccountBalance(), 
                                    account.getcreatedat());
            }
        } catch (Exception e){
            e.printStackTrace();;
        }

    }
    
}
