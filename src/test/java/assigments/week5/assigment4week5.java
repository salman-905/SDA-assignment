package assigments.week5;

import assigments.week6.configration;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import java.util.Set;

/*   Go to URL: http://facebook.com
        getCookies,
        addCookie,
        deleteCookieNamed,
        deleteAllCookies
     */
public class assigment4week5 extends configration {

    @Test
    public void test() {
        driver.navigate().to("http://facebook.com");
//                addCookie,
        driver.manage().addCookie(new Cookie("name", "salman"));
//                deleteCookieNamed,
        driver.manage().deleteCookieNamed("name");
        // getCookies,
        Set<Cookie> Cookie = driver.manage().getCookies();
        System.out.println(Cookie);
//                deleteAllCookies
        driver.manage().deleteAllCookies();

    }


}
