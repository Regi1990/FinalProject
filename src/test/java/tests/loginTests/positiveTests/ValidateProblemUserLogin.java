package tests.loginTests.positiveTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateProblemUserLogin {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String inventoryUrl = "https://www.saucedemo.com/inventory.html";
        String baseUrl = "https://saucedemo.com/";
        String title = "Products";
        driver.get(baseUrl);

        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("problem_user");
        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        String currentUrl = driver.getCurrentUrl();
        if(inventoryUrl.equals(currentUrl)){
            System.out.println("Inventory URL Correct");
        }
        else{
            System.out.println("Inventory URL is Wrong");
        }
        String txtTitle =  driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        if(txtTitle.equals(title)){
            System.out.println("Products Title is Correct");
        }
        else{
            System.out.println("Products Title is Wrong");
        }

        driver.close();
        driver.quit();
    }
}
