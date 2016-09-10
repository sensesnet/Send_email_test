package сheckOutboxTest;

import com.webDriver.CheckOutbox.CheckOutbox;
import org.apache.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by KIRILL on 27.08.2016.
 */
public class CheckOutboxTest {
    CheckOutbox outBox = new CheckOutbox();
    static Logger logger = Logger.getLogger(CheckOutboxTest.class.getName());
    @DataProvider(name = "loginList")
    Object[][] loginList() {
        return new String[][]{
                {  "test4455","test5544" }
//                {"detest00@tut.by", "test0000"},
//                {"detest11@tut.by", "test1111"},
//                {"detest22@tut.by", "test2222"},
//                {"detest33@tut.by", "test3333"},
//                {"detest44@tut.by", "test4444"},
//                {"detest55@tut.by", "test5555"},
//                {"detest66@tut.by", "test6666"},
//                {"detest77@tut.by", "test7777"},
//                {"detest88@tut.by", "test8888"},
//                {"detest99@tut.by", "test9999"},

        };
    }
    @Test(dataProvider = "loginList")
    public void checkOutBox(String email, String pass) throws IOException {
        logger.info(" - start checkOutBox test");
        outBox.CheckOutBox(email, pass);
        logger.info(" - checkOutBox test is ok for"+email);

    }
}
