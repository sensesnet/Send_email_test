package SendEMailTest;

import com.ssl.Sender;
import org.testng.annotations.Test;

import javax.mail.MessagingException;

/**
 * Send e-mail from account 1 to account 2 (use Java Mail API)
 */
public class SendMailTest {

    String sender = "detest11@tut.by";
    String senderPass = "test1111";

    @Test
    public void sendmailtest() throws MessagingException {

        // Send e-mail from account 1 to account 2 (use Java Mail API)
        Sender sslSender = new Sender(sender, senderPass);
        sslSender.send("This is Subject MSG", "SSL: This is text MSG!", "detest55@tut.by");
        sslSender.saveMSG();
    }
}

