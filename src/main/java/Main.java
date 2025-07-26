import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import net.datafaker.Faker;

public class Main {

    static Faker faker = new Faker();

    static String name = faker.name().fullName();


    public static void main (String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        WebElement adminTab = driver.findElement(By.xpath("//li//a[contains(@href, 'Admin')]"));
        adminTab.click();

        List<WebElement> records = driver.findElements(By.xpath("//div[@class='oxd-table']//div[@class='oxd-table-card']"));
        System.out.println("list at first=" +records.size());

        WebElement addUserButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
        addUserButton.click();

        WebElement userRoleDropdown = driver.findElement(By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][1]//*[@class='oxd-select-text oxd-select-text--active']"));
        userRoleDropdown.click();

        WebElement  userRole = driver.findElement(By.xpath("//*[contains(text(),'Admin')]"));
        userRole.click();

        WebElement userStatusDropdown = driver.findElement(By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters'][3]//*[@class='oxd-select-text oxd-select-text--active']"));
        userStatusDropdown.click();

        WebElement userStatus = driver.findElement(By.xpath("//*[contains(text(),'Enabled')]"));
        userStatus.click();

        WebElement employeeNameSearchInput = driver.findElement(By.xpath("//*[.='Employee Name']//input"));
        employeeNameSearchInput.sendKeys("FName");
        WebElement selectEmployeeName = driver.findElement(By.xpath("//*[contains(text(),'FName')]"));
        selectEmployeeName.click();

        WebElement newUserUsername = driver.findElement(By.xpath("//*[.='Username']//input"));
        newUserUsername.sendKeys(name);


        WebElement newUserPassword = driver.findElement(By.xpath("//*[.='Password']//input"));
        newUserPassword.sendKeys("@Dawood00");

        WebElement newUserConfirmPassword = driver.findElement(By.xpath("//*[.='Confirm Password']//input"));
        newUserConfirmPassword.sendKeys("@Dawood00");

        WebElement saveButton = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        saveButton.click();


         //here this xpath returned all the elements related to Employee Name text so for example to reach the employee name you need 4 inner tags so it will return 4 elements
         // ==>      //*[.='Employee Name']

        Thread.sleep(5000);


        List<WebElement> records2 = driver.findElements(By.xpath("//div[@class='oxd-table']//div[@class='oxd-table-card']"));
        System.out.println("list after adding a user=" +records.size());
        System.out.println("list2 after deleting a user=" +records2.size());
        Assert.assertEquals(records2.size(), records.size()+1);
        WebElement usernameSearchInput = driver.findElement(By.xpath("//*[.='Username']//input"));
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.visibilityOf(usernameSearchInput));
        usernameSearchInput.sendKeys(name);

        WebElement usernameSearchButton = driver.findElement(By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']"));
        usernameSearchButton.click();

        WebElement deleteUsernameIcon = driver.findElement(By.xpath("//*[@class='oxd-icon bi-trash']"));
        deleteUsernameIcon.click();

        WebElement deleteAction = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']"));
        deleteAction.click();
        System.out.println("list after deleting a user=" +records.size());
        System.out.println("list2 after deleting a user=" +records2.size());
        Assert.assertEquals(records2.size()-1, records.size());
    }
}
