package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests {

    @Test
    public void loginWithValidCredentials() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drago\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("da");
    }


}
