package com;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws MessagingException, SQLException, FileNotFoundException {

//        // Read all tests accounts src/main/resources/accounts.txt
//        Readtxt readtxt = new Readtxt();
//        Map accMap = (HashMap) readtxt.read();
//        Set<Map.Entry<String, String>> set = accMap.entrySet();
//        String sender = "test33334444@yandex.ru";
//        String senderPass =  "test4433";
//
//        for (Map.Entry<String, String> accounts : set) {
//            //take unique account
//            System.out.println(accounts.getKey());
//            System.out.println(accounts.getValue());
//            String userMail = accounts.getKey();
//            String password = accounts.getValue();
//
//        // Send e-mail from account 1 to account 2 (use Java Mail API)
//            Sender sslSender = new Sender(sender, senderPass);
//            sslSender.send("This is Subject MSG", "SSL: This is text MSG!", userMail);
//            sslSender.saveMSG();
//
//        //Log in to acc1 from UI. Check e-mail in Sent present
//            CheckingOutbox checkingOutbox = new CheckingOutbox(sender, senderPass);
//            checkingOutbox.check();
//
//        // Log in to acc2 from UI. Check e-mail in Inbox
//            CheckingInbox checkingInbox = new CheckingInbox(userMail, password);
//            checkingInbox.check();
//
//        //store accounts in xml
//            SaveToXML saveToXML = new SaveToXML();
//            saveToXML.saveToXML(userMail, password);
//
//        //store accounts in csv
//            SaveToCSV saveToCSV = new SaveToCSV();
//            saveToCSV.saveToSCV(userMail, password);
//
//        // store accounts in DB
//            Account account = new Account();
//            AccountDao accountDao = AccountDao.getInstanse();
//            account.setUserName(userMail);
//            account.setPassword(password);
//            accountDao.add(account);
//
//        //Change sender
////            sender=userMail;
////            senderPass=password;
////            System.out.println(sender);
////            System.out.println(senderPass);
//
//
//        }
   }


}
