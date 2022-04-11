package com.sfdc;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.InputMethodEvent;
import java.util.concurrent.TimeUnit;

public class TC_Login_001 extends Baseclass
{
    public TC_Login_001() throws AWTException {
    }

    @Test(priority = 1)
    public <javascriptExecutor> void login() throws InterruptedException, AWTException {
        driver.get(url);
        driver.manage().window().maximize();
        logger.info("LikedIn Login page is opened");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        driver.findElement(By.id("username")).sendKeys(email);
        logger.info("Email entered");

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        driver.findElement(By.id("password")).sendKeys(password);
        logger.info("Password Entered");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[contains(text(), 'Sign in')]")).click();
        logger.info("Clicked SignIn button");
        System.out.println(driver.getTitle());
        Alert alert = driver.switchTo().alert();
        alert.getText();
        alert.dismiss();

        /*Robot robot = new Robot();
        robot.mouseMove(500,5);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);*/

        try
        {
            driver.findElement(By.id("fake"));
        }catch (NoSuchElementException e)
        {
            System.out.println("element is not found");
        }

        javascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript(Script, Arguments);

    }

    @Test(priority = 2)
    public void openProfile()
    {
        driver.get("https://www.linkedin.com/in/azarkabeer/");
        logger.info("opened profile");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[starts-with(@href,'/messaging/thread/new?')]")).click();
        logger.info("Clicked Message button");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[starts-with(@class,'msg-form__contenteditable')]")).sendKeys("This is an automated message");
        logger.info("Message Typed");
        driver.findElement(By.xpath("//div[starts-with(@class,'msg-form__contenteditable')]")).sendKeys(Keys.ENTER);


    }
    public static void sendKeys (WebDriver driver1, WebElement element, int timeout, String value)
    {
        new WebDriverWait(driver1, timeout).until(ExpectedConditions.visibilityOf(element));
    }
}


