package assigments.week6;

import org.apache.logging.log4j.Logger;
import org.example.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

/*
Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
Add 10 notes using data provider with excel
Run it with 3 different browsers using XML file
Run it parallel with 3 threads
*/
public class AssignmentTask2Test {

    WebDriver driver;
    Wait wait;
    ActionsBot bot;
    Logger Logger;

    @BeforeClass
    public void br() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");
    }

    @DataProvider(name = "testdata")
    public Object[][] testData() {
        return new Object[][]{
                {"titel1", "note1"},
                {"titel2", "note2"},
                {"titel3", "note3"},
                {"titel4", "note4"},
                {"titel5", "note5"},
                {"titel6", "note6"},
                {"titel7", "note7"},
                {"titel8", "note8"},
                {"titel9", "note9"},
                {"titel10", "note10"},
        };
    }

    @Test(dataProvider = "testdata")
    public void data(String titel, String note) {
        By title_input = By.id("note-title-input");
        By add = By.id("add-note");
        By notee = By.id("note-details-input");
        driver.findElement(title_input).sendKeys(titel, Keys.RETURN);
        driver.findElement(notee).sendKeys(note, Keys.RETURN);
        driver.findElement(add).click();
    }

 //   @AfterTest

//    public void afftertest() {
//
//        driver.quit();
//
//    }

}