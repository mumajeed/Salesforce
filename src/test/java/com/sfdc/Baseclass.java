package com.sfdc;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Baseclass {
    public static WebDriver driver;
    public static String url = "https://www.linkedin.com/login";
    public static String email = "";
    public static String password = "";
    public static Logger logger;

    @BeforeClass
    public void setUP()
    {
        System.setProperty("webdriver.chrome.driver", "/Users/azarkabeer/IdeaProjects/Salesforce/Drivers/chromedriver");
        driver = new ChromeDriver();
        logger = Logger.getLogger("Ebanking");
        PropertyConfigurator.configure("log4j.properties");
    }

    @AfterClass
    public void teardown()
    {
        driver.quit();
    }
}
