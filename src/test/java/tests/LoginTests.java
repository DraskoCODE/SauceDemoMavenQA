package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTests {

    @Test
    public void verifyLoginWithStandardUser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drago\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.isOpen(), true, "Login failed");

        productsPage.close();

    }

    @Test
    public void verifyLoginWithLockOutUser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drago\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("locked_out_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        Assert.assertEquals(loginPage.isOpen(), true, "Locked_out_user is login to product page");

        loginPage.close();
    }

    public void verifyErrorMessageOnLoginWithLockOutUser() {

    }

    public void verifyLoginWithProblemUser() {

    }

    @Test
    public void verifyLoginWithPerformanceGlitchUser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drago\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("performance_glitch_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        Assert.assertEquals(productsPage.isOpen(), true, "Login failed");

        productsPage.close();
    }



}
