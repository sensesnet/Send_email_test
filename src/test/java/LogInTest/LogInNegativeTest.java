package logInTest;

import com.webDriver.LogIn.LogInNegative;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by KIRILL on 27.08.2016.
 */
public class LogInNegativeTest {
    LogInNegative login = new LogInNegative();
    //----------------------------------------------------------------------
    //negative test

    @Test
    public void invalidLogin() throws IOException {

        login.invalidLogPass("invalid", "test1111");

    }

    @Test
    public void invalidPassword() throws IOException {

        login.invalidLogPass("detest11@tut.by", "invalid");
    }

    @Test
    public void invalidLoginPassword() throws IOException {

        login.invalidLogPass("invalid", "invalid");
    }


    // without login or password
    @Test
    public void withoutLogin() throws IOException {

        login.withoutLogPass("", "test1111");
    }

    @Test
    public void withoutPassword() throws IOException {

        login.withoutLogPass("detest11@tut.by", "");
    }

}
