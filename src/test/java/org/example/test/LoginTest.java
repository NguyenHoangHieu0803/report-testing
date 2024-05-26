package org.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class LoginTest {

    public By userName = By.xpath("//input[@placeholder='Username']");
    public By password = By.xpath("//input[@placeholder='Password']");
    public By loginButton = By.cssSelector("[class='submit-button btn_action']");

    WebDriver driver;
    @BeforeMethod
    void setup() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    void logInSuccessfullyStandardUser() {

        UserData userData = new UserData();
        userData.setUserName("standard_user");
        userData.setpassword("secret_sauce");

        driver.findElement(userName).sendKeys(userData.getUserName());
        driver.findElement(password).sendKeys(userData.getpassword());
        driver.findElement(loginButton).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    void logInSuccessfullyLockedOutUser() {

        UserData userData = new UserData();
        userData.setUserName("locked_out_user");
        userData.setpassword("secret_sauce");

        driver.findElement(userName).sendKeys(userData.getUserName());
        driver.findElement(password).sendKeys(userData.getpassword());
        driver.findElement(loginButton).click();

        Assert.assertTrue(driver
                .findElement(By.xpath("//h3[@data-test='error']"))
                .getText().contains("Epic sadface: Sorry, this user has been locked out."));
    }

    @Test
    void logInSuccessfullyProblemUser() {

        UserData userData = new UserData();
//        userData.setUserName("problem_user");
        userData.setpassword("secret_sauce");

        driver.findElement(userName).sendKeys(userData.getUserName());
        driver.findElement(password).sendKeys(userData.getpassword());
        driver.findElement(loginButton).click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='inventory_list']/div[1]/div[1]/a[1]/img[1]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='inventory_list']/div[2]/div[1]/a[1]/img[1]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='inventory_list']/div[3]/div[1]/a[1]/img[1]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='inventory_list']/div[4]/div[1]/a[1]/img[1]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='inventory_list']/div[5]/div[1]/a[1]/img[1]")).isEnabled());
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class='inventory_list']/div[6]/div[1]/a[1]/img[1]")).isEnabled());

    }

    // lam tiep 3 cach con lai

    @AfterMethod
    void tearDown () {
        driver.quit();
    }

}