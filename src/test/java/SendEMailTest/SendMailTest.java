package SendEMailTest;

import com.inbox.CheckingInbox;
import com.outbox.CheckingOutbox;
import com.saveToDB.dao.AccountDao;
import com.saveToDB.pojos.Account;
import com.saveTofile.SaveToCSV;
import com.saveTofile.SaveToXML;
import com.ssl.Sender;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.sql.SQLException;

/**
 * Send e-mail from account 1 to account 2 (use Java Mail API)
 */
public class SendMailTest {

    String sender = "detest11@tut.by";
    String senderPass = "test1111";
    String recipient =  "detest55@tut.by";
    String recipientpass =  "test5555";

    @Test
    public void sendmailtest() throws MessagingException {

        // Send e-mail from account 1 to account 2 (use Java Mail API)
        Sender sslSender = new Sender(sender, senderPass);
        sslSender.send("This is Subject MSG", "SSL: This is text MSG!", recipient);
        sslSender.saveMSG();
    }

    @Test
    public void checkoutboxtest() {

        //Log in to acc1 from UI. Check e-mail in Sent present (use Java Mail API)
        CheckingOutbox checkingOutbox = new CheckingOutbox(sender, senderPass);
        checkingOutbox.check();
    }

    @Test
    public void checkinboxtest() {

        // Log in to acc2 from UI. Check e-mail in Inbox (use Java Mail API)
        CheckingInbox checkingInbox = new CheckingInbox(recipient, recipientpass);
        checkingInbox.check();
    }
    @Test
    public void savetoDB() throws SQLException {
        // store accounts in DB
        Account account = new Account();
        AccountDao accountDao = AccountDao.getInstanse();
        account.setUserName(recipient);
        account.setPassword(recipientpass);
        accountDao.add(account);
    }
    @Test
    public void savetofile()  {
        //store accounts in xml
        SaveToXML saveToXML = new SaveToXML();
        saveToXML.saveToXML(recipient, recipientpass);

        //store accounts in csv
        SaveToCSV saveToCSV = new SaveToCSV();
        saveToCSV.saveToSCV(recipient, recipientpass);
    }

}

