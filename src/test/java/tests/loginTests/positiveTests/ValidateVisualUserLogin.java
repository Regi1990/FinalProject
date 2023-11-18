package tests.loginTests.positiveTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateVisualUserLogin {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String inventoryUrl = "https://www.saucedemo.com/inventory.html";
        String baseUrl = "https://saucedemo.com/";
        String title = "Products";
        //get url of website
        driver.get(baseUrl);

        //fill user and password information
        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("visual_user");
        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        //validate login input -> positive test
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

        //close connection and end tester
        driver.close();
        driver.quit();
    }
}
