package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

import java.util.ArrayList;
import java.util.List;

public class ProductsTests {

    public static List<String> allItems() {
        List<String> toReturn  = new ArrayList<>();

        toReturn.add("Sauce Labs Bike Light");
        toReturn.add("Sauce Labs Onesie");
        toReturn.add("Sauce Labs Fleece Jacket");
        toReturn.add("Sauce Labs Backpack");
        toReturn.add("Sauce Labs Bolt T-Shirt");
        toReturn.add("Test.allTheThings() T-Shirt (Red)");

        return toReturn;
    }

    public static List<String> twoItems() {
        List<String> toReturn  = new ArrayList<>();

        toReturn.add("Sauce Labs Bike Light");
        toReturn.add("Test.allTheThings() T-Shirt (Red)");

        return toReturn;
    }

    @Test
    public void verifyAddAllProductToCart() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drago\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        //productsPage.addProductToCartByName("Sauce Labs Bike Light"); //Sauce Labs Onesie
        //productsPage.addProductToCartByName("Sauce Labs Onesie");
        List<String> productToAdd = allItems();
        for(int i = 0; i < productToAdd.size(); i++) {
            productsPage.addProductToCartByName(productToAdd.get(i));
        }

        Assert.assertEquals(productsPage.productCountInCart(), productToAdd.size(), "Product count is not equals");

        productsPage.close();
    }

    @Test
    public void verifyAddTwoProductToCart() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drago\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        //productsPage.addProductToCartByName("Sauce Labs Bike Light"); //Sauce Labs Onesie
        //productsPage.addProductToCartByName("Sauce Labs Onesie");
        List<String> productToAdd = twoItems();
        for(int i = 0; i < productToAdd.size(); i++) {
            productsPage.addProductToCartByName(productToAdd.get(i));
        }

        Assert.assertEquals(productsPage.productCountInCart(), productToAdd.size(), "Product count is not equals");

        productsPage.close();
    }

    @Test
    public void verifySortProduct() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\drago\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.setUserName("standard_user");
        loginPage.setPassword("secret_sauce");
        loginPage.clickLogin();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.sortByValue("Price (high to low)");
        productsPage.printProductPrice();

        productsPage.close();

    }

}
