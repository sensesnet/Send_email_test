package com.WebDriver.CheckInbox;

import com.WebDriver.Contacts.Contacts;
import com.WebDriver.WebDrivers.WebDrivers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by KIRILL on 27.08.2016.
 */
public class CheckInBox {

    public void CheckInBox(String email, String pass) throws IOException {
        Contacts con = new Contacts();
        WebDrivers wb = new WebDrivers();

        WebDriver driver = wb.chromeDriver(con.url);

        WebElement userName = driver.findElement(By.id("Username"));
        userName.clear();
        userName.sendKeys(email);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement password = driver.findElement(By.id("Password"));
        password.clear();
        password.sendKeys(pass);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@value='Войти']")).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Assert.assertEquals(driver.findElement(By.cssSelector("span.header-user-name.js-header-user-name")).getText(), email);
    }
}
