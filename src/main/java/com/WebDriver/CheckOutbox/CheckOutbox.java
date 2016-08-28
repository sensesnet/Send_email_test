package com.WebDriver.CheckOutbox;

import com.WebDriver.Contacts.Contacts;
import com.WebDriver.WebDrivers.WebDrivers;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class CheckOutbox {
    static Logger logger = Logger.getLogger(CheckOutbox.class.getName());
    public void CheckOutBox(String email, String pass) throws IOException {
        Contacts con = new Contacts();
        WebDrivers wb = new WebDrivers();
        logger.info(" - try to open chrome");
        WebDriver driver = wb.chromeDriver(con.url);
        logger.info(" - try to set account");
        WebElement userName = driver.findElement(By.id("Username"));
        userName.clear();
        userName.sendKeys(email);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement password = driver.findElement(By.id("Password"));
        password.clear();
        password.sendKeys(pass);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        logger.info(" - try to open account");
        driver.findElement(By.xpath("//input[@value='Войти']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Assert.assertEquals(driver.findElement(By.cssSelector("span.header-user-name.js-header-user-name")).getText(), email);
        //       driver.get(con.url + "/?ncrnd=7863&uid=1130000021539754&login=test3344#inbox");
        //        driver.findElement(By.linkText("Отправленные")).click();
    }
}
