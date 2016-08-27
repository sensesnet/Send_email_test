package com.ssl;

import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Sender {

    private String username;
    private String password;
    private Properties props;
    private Session session;
    private Message message;
    static Logger logger = Logger.getLogger(Sender.class.getName());

    public Sender(String username, String password) {
        this.username = username;
        this.password = password;

        props = new Properties();

        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
    }

    public void send(String subject, String text, String toEmail) {

            logger.info("-try to send email");

        //get session
        session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

            logger.info("-get session successfully");

        try {
            //crt msg
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));         // from
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail)); // to
            message.setSubject(subject);       // subject
            message.setText(text);             //text of mess

            Transport.send(message);
                logger.info("-sent message successfully");

            System.out.println("___step 1_send  mail_______");
            System.out.println("mail sent to:" + toEmail);


        } catch (MessagingException e) {
                logger.error("couldn't to send email");
            throw new RuntimeException(e);
        }
    }

    public void saveMSG() throws MessagingException {

            logger.info("-try to save msg to sent folder");
        //saveTofile msg to sent msg folder
        Store store = session.getStore("imaps");
        store.connect("imap.yandex.ru", username, password);

            logger.info("-try to open sent folder");
        Folder folder = (Folder) store.getFolder("Отправленные");
        if (!folder.exists()) {
            folder.create(Folder.HOLDS_MESSAGES);
        }
        folder.open(Folder.READ_WRITE);
            logger.info("-folder was open");
        folder.appendMessages(new Message[]{message});
            logger.info("-msg was save");
        System.out.println("Msg send and saved ....");
        System.out.println("________________________________");
    }


}
