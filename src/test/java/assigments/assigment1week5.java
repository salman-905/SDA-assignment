package assigments;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
Go to URL: http://demo.guru99.com/test/drag_drop.html
Drag and drop the BANK button to the Account section in DEBIT SIDE
Drag and drop the SALES button to the Account section in CREDIT SIDE
Drag and drop the 5000 button to the Amount section in DEBIT SIDE
Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
Verify the visibility of Perfect text.
*/
public class assigment1week5 extends configration {

    @Test
    public void DropAndDrop() {

        driver.navigate().to("http://demo.guru99.com/test/drag_drop.html");
        By bank = By.xpath("//li[contains(@class,'block14 ui-draggable')]");
        By account = By.id("bank");
        By sales = By.xpath("//li[contains(@class,'block15 ui-draggable')]");
        By credit = By.id("loan");
        By button5000 = By.xpath("//li[contains(@class,'block13 ui-draggable')]");
        By debit = By.id("amt7");
        By button25000 = By.xpath("//li[contains(@class,'block13 ui-draggable')]");
        By amount = By.id("amt8");
        drop(bank, account);
        drop(sales, credit);
        drop(button5000, debit);
        drop(button25000, amount);
        String value = driver.findElement(By.xpath("//a[contains(@class,'button button-green')]")).getText();

        Assert.assertEquals(value, "Perfect!");

    }

    public void drop(By drag, By DRop ) {

        new Actions(driver)
                .dragAndDrop(driver.findElement(drag), driver.findElement(DRop))
                .perform();
    }

}
