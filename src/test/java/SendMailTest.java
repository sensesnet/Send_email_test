import com.inbox.CheckingInbox;
import com.outbox.CheckingOutbox;
import com.ssl.Sender;
import org.testng.annotations.Test;

import javax.mail.MessagingException;
import java.io.FileNotFoundException;

/**
 * Created by KIRILL on 08.08.2016.
 */
public class SendMailTest {




    @Test (priority = 1)
    public void test1() throws FileNotFoundException, MessagingException {
        // Send e-mail from account 1 to account 2 (use Java Mail API)
        Sender sslSender = new Sender("test33334444@yandex.ru", "test4433");
        sslSender.send("This is Subject MSG", "SSL: This is text MSG!", "detest11@tut.by");
        sslSender.saveMSG();
    }

    @Test  (priority = 2)
    public void test2(){
        //Log in to acc1 from UI. Check e-mail in Sent present
        CheckingOutbox checkingOutbox = new CheckingOutbox("test33334444@yandex.ru", "test4433");
        checkingOutbox.check();
    }

    @Test (priority = 3)
    public void test3(){
        // Log in to acc2 from UI. Check e-mail in Inbox
        CheckingInbox checkingInbox = new CheckingInbox("detest11@tut.by", "test1111");
        checkingInbox.check();
    }



}
