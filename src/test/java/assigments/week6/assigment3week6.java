package assigments.week6;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/* go to "https://practicetestautomation.com/practice-test-login/"
enter username - "student"
enter password - "incorrectPassword"
and login
SOFT ASSERT the error message shown
SOFT ASSERT the error message is "Your password is invalid!" */
public class assigment3week6 extends configration {

    String url = "https://practicetestautomation.com/practice-test-login/";
    By username = By.id("username");
    By password = By.id("password");
    By button = By.id("submit");

    By errormsg = By.id("error");

    @Test
    public void test() {
        // go to "https://practicetestautomation.com/practice-test-login/
        bot.navigate(url);
        //enter username - "student"
        bot.type(username, "student");
        //enter password - "incorrectPassword"
        bot.type(password, "incorrectPassword");
        //Login
        bot.click(button);


        SoftAssert softAssert = new SoftAssert();
        boolean s = driver.findElement(errormsg).isDisplayed();
        // SOFT ASSERT the error message shown
        wait.until(webDriver -> driver.findElement(errormsg).isDisplayed());

        softAssert.assertTrue(s, "error ");
        //SOFT ASSERT the error message is "Your password is invalid!"
        softAssert.assertEquals(bot.getText(errormsg), "Your password is invalid!");
        softAssert.assertAll();


    }
}
