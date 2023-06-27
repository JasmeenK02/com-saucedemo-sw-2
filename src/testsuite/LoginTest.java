package testsuite;
/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userShouldLoginSuccessfullyWithValid
 * Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //Enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click on LOGIN button
        driver.findElement(By.id("login-button")).click();
        //Verify the text "PRODUCTS"
        String expectedText = "Products";
        String actualText = driver.findElement(By.xpath("//span[text() = 'Products']")).getText();
        Assert.assertEquals("Products text does not match", expectedText, actualText);
    }
    @Test

    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter password
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        //click on LOGIN button
        driver.findElement(By.id("login-button")).click();
        //Verify that six products are displayed on page
        int expectedProducts = 6;
        int actualProducts = driver.findElements(By.xpath("//div[@class = 'inventory_item']")).size();
        Assert.assertEquals("Products do not match", expectedProducts, actualProducts);


    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
