package com.outbox;

import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.search.FlagTerm;
import java.util.Properties;

public class CheckingOutbox {

    private String username;
    private String password;
    private Properties props;
    private Session session;
    static Logger logger = Logger.getLogger(CheckingOutbox.class.getName());

    public CheckingOutbox(String username, String password) {
        this.username = username;
        this.password = password;

        props = new Properties();
        props.setProperty("mail.host", "imap.yandex.ru");
        props.setProperty("mail.port", "993");
        props.setProperty("mail.transport.protocol", "imaps");
    }

    public void check() {
        logger.info(" - try to check sent folder, ger session");

        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        try {
            Store store = session.getStore("imaps");
            store.connect();

            // show all folders
//            Folder[] f = store.getDefaultFolder().list();
//            for (Folder fd : f)
//                System.out.println(">> " + fd.getName());
            logger.info(" - try to open sent folder");
            // choose inbox folder
            Folder inbox = store.getFolder("Отправленные");
            // open for read
            inbox.open(Folder.READ_ONLY);
            Message messages[] = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

            logger.info("___step 2_check sent mail___________");
            logger.info("Number of sent mails = " + inbox.getMessageCount());
            logger.info("Number of new  mails = " + inbox.getUnreadMessageCount());
            logger.info("____________________________________");

              // show msg
//            for (int i = 0; i < messages.length; i++) {
//                Message message = messages[i];
//                Address[] from = message.getFrom();
//                System.out.println("-------------------------------");
//
//                System.out.println("Date : " + message.getSentDate());
//                System.out.println("From : " + from[0]);
//                System.out.println("Subject: " + message.getSubject());
//                System.out.println("Content :" + message.getContent().toString());
//                System.out.println("-------------------------------");
//            }
            inbox.close(true);
            logger.info(" - inbox folder was close");
            store.close();
        } catch (NoSuchProviderException e) {
            logger.error(" - NoSuchProviderException ");
            e.printStackTrace();
        } catch (MessagingException e) {
            logger.error(" - printStackTrace Exception");
            e.printStackTrace();
        }

    }
}

