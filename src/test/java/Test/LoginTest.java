package Test;

import models.Credentials;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;
import utils.JsonDataReader;

public class LoginTest {


    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    WebDriver driver = DriverFactory.getDriver();
    Credentials creds = JsonDataReader.readJsonFromResources("credentials.json", Credentials.class);

//    @Test
//    public void testValidLogin(){
//        LoginPage loginPage = new LoginPage(driver);
//    }


}
