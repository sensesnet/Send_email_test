package com.webDriver.LogIn;

import com.webDriver.Contacts.Contacts;
import com.webDriver.WebDrivers.WebDrivers;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by KIRILL on 27.08.2016.
 */
public class LogInNegative {
    // negative test without login or pass
    static Logger logger = Logger.getLogger(LogInNegative.class.getName());
    public void withoutLogPass(String email, String pass) throws IOException {
        logger.info(" - negative test without log&pass ");
        Contacts con = new Contacts();
        WebDrivers wb = new WebDrivers();
        logger.info(" - try to open chrome ");
        WebDriver driver = wb.chromeDriver(con.url);
        logger.info(" - try to set account ");
        WebElement userName = driver.findElement(By.id("Username"));
        userName.clear();
        userName.sendKeys(email);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement password = driver.findElement(By.id("Password"));
        password.clear();
        password.sendKeys(pass);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logger.info(" - try to open account ");
        driver.findElement(By.xpath("//input[@value='Войти']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logger.info(" - test is ok ");
        driver.close();
    }
    //wrong login or pass
    public void invalidLogPass(String email, String pass) throws IOException {
        logger.info(" - negative test invalid log&pass ");
        Contacts con = new Contacts();
        WebDrivers wb = new WebDrivers();
        logger.info(" - try to open chrome ");
        WebDriver driver = wb.chromeDriver(con.url);
        logger.info(" - try to set account ");
        WebElement userName = driver.findElement(By.id("Username"));
        userName.clear();
        userName.sendKeys(email);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement password = driver.findElement(By.id("Password"));
        password.clear();
        password.sendKeys(pass);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logger.info(" - try to open account ");
        driver.findElement(By.xpath("//input[@value='Войти']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Assert.assertEquals(driver.findElement(By.cssSelector("fieldset > strong")).getText(), "Неверное имя пользователя или пароль");
        logger.info(" - test is ok ");
        driver.close();
    }
}
