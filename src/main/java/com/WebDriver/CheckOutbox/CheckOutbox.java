package com.webDriver.CheckOutbox;

import com.webDriver.Contacts.Contacts;
import com.webDriver.WebDrivers.WebDrivers;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

        //Assert.assertEquals(driver.findElement(By.cssSelector("span.header-user-name.js-header-user-name")).getText(), email);
        //       driver.get(con.url + "/?ncrnd=7863&uid=1130000021539754&login=test3344#inbox");
        //        driver.findElement(By.linkText("Отправленные")).click();


        //<a class="b-folders__folder__link" href="#inbox/extra_cond=only_new">
        // <span class="b-folders__folder__link__i"><span class="b-folders__folder__link__i"></span>
        // </span>5</a>
        String i= driver.findElement(By.cssSelector("span.b-folders__folder__link.b-folders__folder__link__i")).getText();
        //Assert.assertEquals(driver.findElement(By.cssSelector("b-folders__folder__counters__total")).getCssValue(),i);
        System.out.println("ZZZZZZZZZZZZZZZZZZZZZ = "+ i);
        //<div data-params="fid=4" class="b-folders__folder b-folders__folder_droppable js-valid-drag-target js-context-menu-target fid-4 b-folders__folder_sent b-folders__folder_current"><span class="b-folders__folder__info"><span class="b-folders__counters"><span class="b-folders__folder__counters__total">14</span></span></span><span class="b-folders__folder__name"><a class="b-folders__folder__link" title="Отправленные" data-action="move" data-params="current_folder=4" href="#sent"><span class="b-folders__folder__icon"></span>Отправленные</a></span><div class="b-folders__folder__tail"></div></div>
        //<span class="b-folders__folder__info"><span class="b-folders__counters"><span class="b-folders__folder__counters__total">14</span></span></span>
        //<span class="b-folders__counters"><span class="b-folders__folder__counters__total">14</span></span>
        //<span class="b-folders__counters"><span class="b-folders__folder__counters__total">14</span></span>
        //<a class="b-folders__folder__link" href="#inbox/extra_cond=only_new"><span class="b-folders__folder__link__i"><span class="b-folders__folder__link__i"></span></span>1</a>
        //<span class="b-folders__folder__counters__total"> / 1</span>
    }
}
