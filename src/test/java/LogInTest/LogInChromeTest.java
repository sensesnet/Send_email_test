package LogInTest;

/**
 * Log in to acc1 from UI. Check e-mail in Sent present  (WebDriver)
 * Log in to acc2 from UI. Check e-mail in Inbox (WebDriver)
 */

import com.WebDriver.LogIn.LogIn;
import org.testng.annotations.Test;

import java.io.IOException;

public class LogInChromeTest {

    LogIn login = new LogIn();


    @Test
    public void correctLogin() throws IOException {

        login.loginChrome("detest11@tut.by", "test1111");

    }

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
