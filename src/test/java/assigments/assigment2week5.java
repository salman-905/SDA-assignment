package assigments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/** ( This task should be managed with keyboard actions ) */
// go to https://www.google.com/
// search for "Scroll Methods" by using an Actions object
public class assigment2week5  extends configration {
    @Test
    public void task1 ()
    {

    driver.navigate().to("https://www.google.com/");
       // By search = By.xpath( "//textarea[contains(@class,'gLFyf')]");
       Actions actions= new Actions(driver);
             actions.sendKeys( "Scroll Methods", Keys.RETURN).perform();


    }


}
