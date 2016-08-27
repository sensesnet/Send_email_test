package LogInTest;

/**
 * Log in to acc1 from UI. Check e-mail in Sent present  (WebDriver)
 * Log in to acc2 from UI. Check e-mail in Inbox (WebDriver)
 */

import com.WebDriver.LogIn.LogIn;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogInChromeTest {

    LogIn login = new LogIn();


    @DataProvider(name = "loginList")
    Object[][] loginList() {
        return new String[][]{
                {"detest00@tut.by", "test0000"},
                {"detest11@tut.by", "test1111"},
                {"detest22@tut.by", "test2222"},
                {"detest33@tut.by", "test3333"},
                {"detest44@tut.by", "test4444"},
                {"detest55@tut.by", "test5555"},
                {"detest66@tut.by", "test6666"},
                {"detest77@tut.by", "test7777"},
                {"detest88@tut.by", "test8888"},
                {"detest99@tut.by", "test9999"},

        };
    }

    @Test (dataProvider = "loginList")
    public void correctLogin(String email, String pass) throws IOException {

      login.loginChrome(email, pass);

    }
    //----------------------------------------------------------------------
    //negative test

    @Test
    public void invalidLogin() throws IOException {

        login.loginChrome("invalid", "test1111");

    }

    @Test
    public void invalidPassword() throws IOException {

        login.loginChrome("detest11@tut.by", "invalid");
    }

    @Test
    public void invalidLoginPassword() throws IOException {

        login.loginChrome("invalid", "invalid");
    }

    @Test
    public void withoutLogin() throws IOException {

        login.loginChrome("", "test1111");
    }

    @Test
    public void withoutPassword() throws IOException {

        login.loginChrome("detest11@tut.by", "");
    }
}
