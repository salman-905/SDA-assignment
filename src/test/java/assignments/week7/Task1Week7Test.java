package assignments.week7;

import assignments.week6.configration;
import SDA_Salman.assigmentsweek7fluent.example.RegisterAccount;
import org.testng.annotations.Test;

/*
  go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
  register account test with fluent page object approach
         */
public class Task1Week7Test extends configration {
    @Test
    public void registerTest() {
      new RegisterAccount(bot, driver).goTo().registerAccount().assertRegister();
    }

    }




