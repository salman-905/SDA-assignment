package assigments.week5;

import assigments.week6.configration;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/*
   Go to Amazon
   Scroll to the bottom of the page using a robot
   Click on the "Back to top" web element
   Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
   Use Actions to type "ClarusWay" in the search box and perform the search
*/
public class assigment3week5 extends configration {
    @Test
    public void task() throws AWTException {
        //Go to Amazon
        driver.navigate().to("https://www.amazon.sa/-/en/");

        //  Scroll to the bottom of the page using a robot
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_END);
        //Click on the "Back to top" web element
        By BackToTop =  By.id("nav-xshop");
        WebElement BackToTop1 = driver.findElement(BackToTop);
        new Actions(driver)
                .scrollToElement(BackToTop1).perform();
        wait.until(webDriver -> BackToTop1.isDisplayed());
        //Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        By logoClick = By.xpath("//a[contains(@href,'/-/en/?ref_=footer_logo')]");
        WebElement LOGO = driver.findElement(logoClick);
        wait.until(webDriver -> LOGO.isDisplayed());
        js.executeScript("arguments[0].click();", LOGO);
        //   Use Actions to type "ClarusWay" in the search box and perform the search
        By searchBoxText = By.id("twotabsearchtextbox");
        WebElement search =  driver.findElement(searchBoxText);
      new Actions(driver)
              .sendKeys(search, "ClarusWay", Keys.RETURN)
              .perform();
    }

}
