package SDA_Salman.assigmentsweek7fluent.example;

import io.qameta.allure.Step;
import SDA_Salman.assigmentsweek7fluent.example.org.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class RegisterAccount extends Pages {


    By firstname = By.id("input-firstname");
    By lastname = By.id("input-lastname");

    By inputEmail = By.id("input-email");

    By inputTelephone = By.id("input-telephone");

    By inputPassword = By.id("input-password");
    By inputConfirmPASS = By.id("input-confirm");

    By inputAgree = By.id("input-agree");
    //div[contains(@class,'custom-control custom-checkbox custom-control-inline')]
    private By accountCreatedBy = By.cssSelector("h1.page-title");
    public RegisterAccount(ActionsBot bot, WebDriver driver) {
        super(bot, driver);
    }


    @Step("navigate to register page")
    public RegisterAccount goTo() {
        driver.navigate().to("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        return this;
    }

    @Step("register account")
    public RegisterAccount registerAccount() {
        bot.type(firstname, "salman");
        bot.type(lastname, "alghanem");
        bot.type(inputEmail, "q-5-@yopmail.com");
        bot.type(inputTelephone, "055555069");
        bot.type(inputPassword, "9s8l7nKqqt");
        bot.type(inputConfirmPASS, "9s8l7nKqqt");
        bot.click(inputAgree);
//        driver.findElement(inputAgree).click();
        driver.findElement(By.xpath("//input[contains(@class,'btn btn-primary')]")).click();
        return this;

    }


    @Step("")
    public void assertRegister(){
        Assert.assertEquals(bot.getText(accountCreatedBy),"Your Account Has Been Created!");
    }


}

