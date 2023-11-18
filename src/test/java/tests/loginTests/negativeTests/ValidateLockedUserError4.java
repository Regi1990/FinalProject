package tests.loginTests.negativeTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateLockedUserError4 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String inventoryUrl = "https://www.saucedemo.com/inventory.html";
        String baseUrl = "https://saucedemo.com/";
        driver.get(baseUrl);

        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("");
        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        String error  = "Epic sadface: Username is required";
        String txtMessage =  driver.findElement(By.cssSelector("[data-test=\"error\"]")).getText();

        if(error.equals(txtMessage)){
            System.out.println("Login Failed And Received Right Error message ");
        }
        else{
            System.out.println("Login Failed And Received Wrong Error message ");
        }

        driver.close();
        driver.quit();
    }
}
