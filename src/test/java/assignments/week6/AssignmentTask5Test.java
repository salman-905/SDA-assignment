package assignments.week6;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

//Go to URL: http://crossbrowsertesting.github.io/
//Click to To-Do App
//Checking Box to do-4 and Checking Box to do-5
//If both clicks worked, then the following List should be have length 3.
//Assert that this is correct
//Assert that the to do we added is present in the list
//Archiving old todos
//If our archive link worked, then the following list should have length 4.
//Assert that this is true as well
//Doing Cross Browser Testing.
public class AssignmentTask5Test extends configration {

    @Test
    public void crossbrowsertesting() throws InterruptedException {
        By ToDoApp = By.xpath("//a[text()='To-Do App']");
        By todo4 = By.name("todo-4");
        By todo5 = By.name("todo-5");
        By check = By.xpath("//span[contains(@class,'ng-binding')]");
        By checkToDo4 = By.xpath("//span[text()='Build selenium grid, buy devices, and setup a test lab - $$$']");
        By checkToDo5 = By.xpath("//span[text()='Hire an FTE to manage the lab - more $$$']");


        bot.navigate("http://crossbrowsertesting.github.io/");
        //Click to To-Do App
        bot.click(ToDoApp);
        //Checking Box to do-4 and Checking Box to do-5
        bot.click(todo4);
        bot.click(todo5);
        //If both clicks worked, then the following List should be have length 3.
        driver.findElement(check).getText();
        //Assert that this is correct
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(check).getText(), "3 of 5 remaining");
        //Assert that the to do we added is present in the list
        driver.findElement(By.id("todotext")).sendKeys("present", Keys.RETURN);
        softAssert.assertEquals(driver.findElement(checkToDo4).getText(), "Build selenium grid, buy devices, and setup a test lab - $$$");
        softAssert.assertEquals(driver.findElement(checkToDo5).getText(), "Hire an FTE to manage the lab - more $$$");
        softAssert.assertAll();
        //
        //Archiving old todos
        By Archive = By.xpath("//a[text()='archive']");
        bot.click(Archive);
        //If our archive link worked, then the following list should have length 4.
        Assert.assertEquals(driver.findElement(check).getText(), "4 of 4 remaining");


        //Assert that this is true as well


    }

}
