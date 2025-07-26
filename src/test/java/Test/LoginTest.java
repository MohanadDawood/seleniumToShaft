package Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {



    String username = "Admin";
    String password = "admin123";

    @Test
    public void testValidLogin(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username,password);
    }


}
