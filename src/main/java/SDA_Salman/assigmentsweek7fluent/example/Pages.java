package SDA_Salman.assigmentsweek7fluent.example;

import SDA_Salman.assigmentsweek7fluent.example.org.ActionsBot;
import org.openqa.selenium.WebDriver;

public abstract class Pages {


  public final WebDriver driver;
  public final ActionsBot bot;

    public Pages(ActionsBot bot, WebDriver driver) {
        this.bot = bot;
        this.driver = driver;
    }


}
