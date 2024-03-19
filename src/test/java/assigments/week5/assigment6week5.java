package assigments.week5;

import assigments.week6.configration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;

import java.io.IOException;

// Go to amazon.com
// Take Full Page Screenshot.
// Take any spesific WebElement ScreenShot
public class assigment6week5 extends configration {


    @Test
    public void screenshotTests() throws IOException {
        // Go to amazon.com
        bot.navigate("https://www.amazon.sa");

        // Take Full Page Screenshot.
        File fullPageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(fullPageScreenshot, new File("target/fullPageScreenshot.png"));

        // Take any spesific WebElement ScreenShot
        File elementScreenshot = driver.findElement(By.cssSelector("div#nav-belt")).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(elementScreenshot, new File("target/elementScreenshot.png"));

    }
}
