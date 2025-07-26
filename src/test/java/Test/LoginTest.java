package Test;

import models.Credentials;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;
import utils.JsonDataReader;

public class LoginTest {


    WebDriver driver = DriverFactory.getDriver();
    Credentials creds = JsonDataReader.readJsonFromResources("credentials.json", Credentials.class);

    @Test
    public void testValidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(creds.getUsername(),creds.getPassword());
    }


}
