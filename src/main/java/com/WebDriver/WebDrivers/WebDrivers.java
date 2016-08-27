package com.WebDriver.WebDrivers;


import com.WebDriver.Contacts.Contacts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class WebDrivers {

    Contacts con = new Contacts();

    public WebDriver fireFoxDriver(String url) {
        WebDriver driver = new FirefoxDriver();
        driver.get(url);
        return driver;
    }

    public WebDriver chromeDriver(String url) throws IOException {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(con.chromeDriverPath))
                .usingAnyFreePort()
                .build();
        service.start();
        WebDriver driver = new ChromeDriver(service);
        driver.get(con.url);
        return driver;
    }
}


