package assigments.week6;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */
public class assigment1week6   {
WebDriver driver;

    @BeforeClass

    public void BeforeClass()

    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);

    }
    @Test( testName = "facebook")
    public void facebook()

    {
driver.navigate().to("https://www.facebook.com/?locale=ar_AR");

    }



    @Test( testName = "google",dependsOnMethods = "facebook")
    public void google()

    {
driver.navigate().to("https://www.google.com/");

    }

    @Test( testName = "amazon",dependsOnMethods = "google")
    public void amazon()

    {
        driver.navigate().to("https://www.amazon.com/");

    }

    @AfterClass

    public void AfterMethod()

    {
        driver.quit();
    }

}
