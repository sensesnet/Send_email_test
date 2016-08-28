package SendEMailTest;


import com.createReport.CreateReport;
import com.inbox.CheckingInbox;
import com.itextpdf.text.DocumentException;
import com.outbox.CheckingOutbox;
import com.saveToDB.dao.AccountDao;
import com.saveToDB.pojos.Account;
import com.saveTofile.SaveToCSV;
import com.ssl.Sender;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.sql.SQLException;

/**
 * Send e-mail from account 1 to account 2 (use Java Mail API)
 */
public class SendMailTest {
    static Logger logger = Logger.getLogger(SendMailTest.class.getName());
    CreateReport createReport = new CreateReport();          //pdf form report

    @DataProvider(name = "loginList_1")
    Object[][] loginList1() {
        return new String[][]{
                //sender; sender pass;
                {"detest00@tut.by", "test0000"},
                {"detest11@tut.by", "test1111"},
                {"detest22@tut.by", "test2222"},
                {"detest33@tut.by", "test3333"},
//                {"detest44@tut.by", "test4444"},
//                {"detest55@tut.by", "test5555"},
//                {"detest66@tut.by", "test6666"},
//                {"detest77@tut.by", "test7777"},
//                {"detest88@tut.by", "test8888"},
//                {"detest99@tut.by", "test9999"},

        };
    }
    @DataProvider(name = "loginList_2")
    Object[][] loginList2() {
        return new String[][]{
                //sender; sender pass; recipient
                {"detest00@tut.by", "test0000","detest11@tut.by"},
                {"detest11@tut.by", "test1111","detest22@tut.by"},
                {"detest22@tut.by", "test2222","detest33@tut.by"},
                {"detest33@tut.by", "test3333","detest44@tut.by"},
//                {"detest44@tut.by", "test4444","detest55@tut.by"},
//                {"detest55@tut.by", "test5555","detest66@tut.by"},
//                {"detest66@tut.by", "test6666","detest77@tut.by"},
//                {"detest77@tut.by", "test7777","detest88@tut.by"},
//                {"detest88@tut.by", "test8888","detest99@tut.by"},
//                {"detest99@tut.by", "test9999","detest00@tut.by"},

        };
    }

    @BeforeTest
    public  void openPDF(){
        //Open pdf
        createReport.openPdf();
        logger.info(" - open pdf ");
    }
    @AfterTest
    public  void closePDF() throws DocumentException {
        //Close pdf
        createReport.closePDF();
        logger.info(" - crt pdf ");
    }

    @Test(dataProvider = "loginList_2")
    public void sendmailtest(String sender,String senderPass,String recipient) throws MessagingException, DocumentException {
        logger.info(" - start sendmailtest");
        // Send e-mail from account 1 to account 2 (use Java Mail API)
        Sender sslSender = new Sender("test33334444@yandex.ru", "test4433");
        //Sender sslSender = new Sender(sender, senderPass);
        sslSender.send("This is Subject MSG", "SSL: This is text MSG!", recipient);
        sslSender.saveMSG();
        //Save to report form
        createReport.addLineToPDF(recipient, "Passed", "log info");
        logger.info(" - sendmailtest is ok");

    }

    @Test (dataProvider = "loginList_1")
    public void checkoutboxtest(String sender,String senderPass) {
        logger.info(" - start checkoutboxtest");
        //Log in to acc1 from UI. Check e-mail in Sent present (use Java Mail API)
        CheckingOutbox checkingOutbox = new CheckingOutbox(sender, senderPass);
        checkingOutbox.check();
        logger.info(" - checkoutboxtest is ok");
    }

    @Test (dataProvider = "loginList_1")
    public void checkinboxtest(String recipient,String recipientpass) {
        logger.info(" - start checkinboxtest");
        // Log in to acc2 from UI. Check e-mail in Inbox (use Java Mail API)
        CheckingInbox checkingInbox = new CheckingInbox(recipient, recipientpass);
        checkingInbox.check();
        logger.info(" - checkinboxtest is ok");
    }

    @Test (dataProvider = "loginList_1")
    public void savetoDB(String recipient, String recipientpass) throws SQLException {
        // store accounts in DB
        logger.info(" - start savetoDB");
        Account account = new Account();
        AccountDao accountDao = AccountDao.getInstanse();
        account.setUserName(recipient);
        account.setPassword(recipientpass);
        accountDao.add(account);
        logger.info(" -  savetoDB is ok");
    }

    @Test (dataProvider = "loginList_1")
    public void savetofile(String recipient,String recipientpass)  {
        logger.info(" - start savetofile");
        //store accounts in csv
        SaveToCSV saveToCSV = new SaveToCSV();
        saveToCSV.saveToSCV(recipient, recipientpass);
        logger.info(" - savetofile is ok");
    }


}

