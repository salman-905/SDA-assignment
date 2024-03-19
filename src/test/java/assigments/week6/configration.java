package assigments.week6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.example.ActionsBot;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.time.Duration;

public class configration  {



    public static WebDriver driver;
    protected static Wait<WebDriver> wait;
    protected static Logger logger;
    protected static ActionsBot bot;
    protected static JSONObject testData;



    @BeforeClass
    public static void beforeAll() throws IOException, ParseException {

        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = (Logger) LogManager.getLogger(configration.class.getName());
        //  testData =  (JSONObject) new JSONParser().parse( new FileReader("src/test/resources/testData/sample.json", StandardCharsets.UTF_8) );
        beforeEach();
    }

   // @BeforeMethod
    public static void beforeEach() {
        logger.info("Opening Chrome Browser");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);

        logger.info("Configuring 5 second explicit wait");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        bot=new ActionsBot(driver,wait,logger);
    }

    @AfterMethod
    public void afterEach() {
        logger.info("Quitting Browser");
      //  driver.quit();
    }
}




