package org.example.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HappyCaseTest {

//    @BeforeTest
//    void beforeEach () {
//
//    }

    @Test
    void happyCaseVerification () {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[class='submit-button btn_action']")).click();
        driver.findElement(By.xpath("//button[@name='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        driver.findElement(By.cssSelector("[class='btn btn_action btn_medium checkout_button ']")).click();
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Nguyen");
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Ben");
        driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys("123456");
        driver.findElement(By.cssSelector("[id='continue']")).click();
        driver.findElement(By.cssSelector("[id='finish']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//h2[@class='complete-header']")).isDisplayed());
        driver.findElement(By.xpath("//button[@id='back-to-products']")).click();;
        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
        driver.quit();


    }

}
