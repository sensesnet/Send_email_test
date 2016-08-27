package LogInTest;

import com.WebDriver.LogIn.LogIn;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by KIRILL on 27.08.2016.
 */
public class LogInFireFoxTest {
    LogIn login = new LogIn();


    @Test
    public void correctLogin() throws IOException {

        login.loginFireFox("detest11@tut.by", "test1111");

    }

    @Test
    public void invalidLogin() throws IOException {

        login.loginFireFox("invalid", "test1111");

    }

    @Test
    public void invalidPassword() throws IOException {

        login.loginFireFox("detest11@tut.by", "invalid");
    }

    @Test
    public void invalidLoginPassword() throws IOException {

        login.loginFireFox("invalid", "invalid");
    }

    @Test
    public void withoutLogin() throws IOException {

        login.loginFireFox("", "test1111");
    }

    @Test
    public void withoutPassword() throws IOException {

        login.loginFireFox("detest11@tut.by", "");
    }
}
