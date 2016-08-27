package com;

import com.createReport.CreateReport;
import com.inbox.CheckingInbox;
import com.itextpdf.text.DocumentException;
import com.outbox.CheckingOutbox;
import com.readAcctxt.Readtxt;
import com.saveToDB.dao.AccountDao;
import com.saveToDB.pojos.Account;
import com.saveTofile.SaveToCSV;
import com.saveTofile.SaveToXML;
import com.ssl.Sender;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws MessagingException, SQLException, FileNotFoundException, DocumentException {

//      //Open pdf
        CreateReport createReport = new CreateReport();
        createReport.openPdf();

        // Read all tests accounts src/main/resources/accounts.txt
        Readtxt readtxt = new Readtxt();
        Map accMap = (HashMap) readtxt.read();
        Set<Map.Entry<String, String>> set = accMap.entrySet();
        String sender = "test33334444@yandex.ru";
        String senderPass = "test4433";

        try {
            for (Map.Entry<String, String> accounts : set) {
                //take unique account
                System.out.println(accounts.getKey());
                System.out.println(accounts.getValue());
                String userMail = accounts.getKey();
                String password = accounts.getValue();

                // Send e-mail from account 1 to account 2 (use Java Mail API)
                Sender sslSender = new Sender(sender, senderPass);
                sslSender.send("This is Subject MSG", "SSL: This is text MSG!", userMail);
                sslSender.saveMSG();

                //Log in to acc1 from UI. Check e-mail in Sent present
                CheckingOutbox checkingOutbox = new CheckingOutbox(sender, senderPass);
                checkingOutbox.check();

                // Log in to acc2 from UI. Check e-mail in Inbox
                CheckingInbox checkingInbox = new CheckingInbox(userMail, password);
                checkingInbox.check();

                //store accounts in xml
                SaveToXML saveToXML = new SaveToXML();
                saveToXML.saveToXML(userMail, password);

                //store accounts in csv
                SaveToCSV saveToCSV = new SaveToCSV();
                saveToCSV.saveToSCV(userMail, password);

                // store accounts in DB
                Account account = new Account();
                AccountDao accountDao = AccountDao.getInstanse();
                account.setUserName(userMail);
                account.setPassword(password);
                accountDao.add(account);

                //Save to report form
                createReport.addLineToPDF(userMail, "Passed", "log info");

                //Change sender
                sender = userMail;
                senderPass = password;
                System.out.println(sender);
                System.out.println(senderPass);


            }
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            createReport.closePDF();
        }
    }


}
