package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

        WebDriver driver;

        public LoginPage(WebDriver driver){
                this.driver = driver;
                PageFactory.initElements(driver, this);
        }

        @FindBy(xpath = "//input[@name='username']")
        WebElement usernameInput;

        @FindBy(xpath = "//input[@name='password']")
        WebElement passwordInput;

        @FindBy(xpath = "//button[@type='submit']")
        WebElement loginButton;

        public void enterLoginUserName(String username){
                usernameInput.sendKeys(username);
        }

        public void enterLoginPassword(String password){
                passwordInput.sendKeys(password);
        }

        public void submitLogin(){
                loginButton.click();
        }


        public void login(String username , String password){
                enterLoginUserName(username);
                enterLoginPassword(password);
                submitLogin();
        }



}
