package assignments.week6;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//Open the site: http://opencart.abstracta.us/index.php?route=account/login
//Login with that credentials
//Email: clarusway@gmail.com
//Password: 123456789
//Using the Search function do it with Data Provider for Mac, iPad and Samsung.
public class assigment4week6 extends configration {
    By email = By.id("input-email");
    By pass = By.id("input-password");
    By button = By.xpath("//input[contains(@class,'btn btn-primary')]");
    By search = By.xpath("//input[contains(@class,'form-control input-lg')]");


    @DataProvider(name = "testdata")
    public Object[][] testData() {
        return new Object[][]{
                {"Mac"}, {"ipad"}, {"Samsung"}
        };
    }


    @Test
    public void login() {
        bot.navigate("http://opencart.abstracta.us/index.php?route=account/login");

        bot.type(email, "clarusway@gmail.com");
        bot.type(pass, "123456789");
        bot.click(button);

    }


    @Test(dataProvider = "testdata")
    public void search(String decice) {

        wait.until(webDriver -> driver.findElement(search).isDisplayed());
        driver.findElement(search).sendKeys(decice, Keys.RETURN);
        driver.findElement(search).clear();
    }
}
