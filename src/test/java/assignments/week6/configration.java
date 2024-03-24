package assignments.week6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.example.ActionsBot;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;

public class configration {


    public static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Logger logger;
    protected static ActionsBot bot;
    protected static JSONObject testData;


    @Parameters("target-browser")
    @BeforeClass
    public void setUp(@Optional("chrome") String browser) {
//        logger.info("Opening Chrome Browser");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("start-maximized");
//        driver = new ChromeDriver(chromeOptions);
        Configurator.initialize(null, "src/main/resources/properties/log4j2.properties");
        logger = (Logger) LogManager.getLogger(configration.class.getName());
        //  testData =  (JSONObject) new JSONParser().parse( new FileReader("src/test/resources/testData/sample.json", StandardCharsets.UTF_8) );

        switch (browser.toLowerCase()) {
            case "chrome":

                driver = new ChromeDriver();
                break;
            case "firefox":

                driver = new FirefoxDriver();
                break;
            case "edge":

                driver = new EdgeDriver();
                break;
            // Add cases for other browsers if needed
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }


        logger.info("Configuring 5 second explicit wait");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        bot = new ActionsBot(driver, wait, logger);

    }


    @AfterMethod
    public void afterEach() {
        logger.info("Quitting Browser");
        //  driver.quit();
    }
}




