package tests.sanityTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BuyProductsScenario {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String inventoryUrl = "https://www.saucedemo.com/inventory.html";
        String baseUrl = "https://saucedemo.com/";
        String title = "Products";
        //get url of website
        driver.get(baseUrl);

        //fill data to login page
        driver.findElement(By.cssSelector("[data-test=\"username\"]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("[data-test=\"login-button\"]")).click();

        String currentUrl = driver.getCurrentUrl();

        //check if url is valid
        if(inventoryUrl.equals(currentUrl)){
            System.out.println("Inventory URL Correct");
        }
        else{
            System.out.println("Inventory URL is Wrong");
        }

        //check if title of page is valid
        String txtTitle =  driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        if(txtTitle.equals(title)){
            System.out.println("Products Title is Correct");
        }
        else{
            System.out.println("Products Title is Wrong");
        }

        //choose 2 items and count them later
        driver.findElement(By.cssSelector("[data-test=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.findElement(By.cssSelector("[data-test=\"add-to-cart-sauce-labs-fleece-jacket\"]")).click();
        String numOfItems = driver.findElement(By.cssSelector("[class=\"shopping_cart_badge\"]")).getText();
        int num = Integer.parseInt(numOfItems);

        if(num==2){
            System.out.println("number of items is correct");
        }
        else{
            System.out.println("number of items is Wrong");
        }

        driver.findElement(By.cssSelector("[class=\"shopping_cart_link\"]")).click();


        //check if cart url is valid
        String cartUrl = "https://www.saucedemo.com/cart.html";
        if(driver.getCurrentUrl().equals(cartUrl)){
            System.out.println("Cart URL Correct");
        }
        else{
            System.out.println("Cart URL Wrong");
        }

        //check if title valid on cart url
        txtTitle =  driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        if(txtTitle.equals("Your Cart")){
            System.out.println("Cart Title is Correct");
        }
        else{
            System.out.println("Cart Title is Wrong");
        }

        String s1 = "empty";
        String s2 = "empty";

        //check if we have 2 items in cart url
        s1 = driver.findElement(By.cssSelector("[id=\"item_5_title_link\"]")).getText();
        s2 = driver.findElement(By.cssSelector("[id=\"item_4_title_link\"]")).getText();

        if(!s1.equals("empty") && !s2.equals("empty")){
            System.out.println("number of items is correct");
        }
        else{
            System.out.println("number of items is Wrong");
        }

        driver.findElement(By.cssSelector("[data-test=\"checkout\"]")).click();

        //check if url valid on checkout step 1
        String urlCheckoutStep1 = "https://www.saucedemo.com/checkout-step-one.html";

        if(driver.getCurrentUrl().equals(urlCheckoutStep1)){
            System.out.println("Checkout Step1 URL Correct");
        }
        else{
            System.out.println("Checkout Step1 URL is Wrong");
        }

        //check if title valid on Checkout step1 url
        txtTitle =  driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        if(txtTitle.equals("Checkout: Your Information")){
            System.out.println("Checkout Step1 Title is Correct");
        }
        else{
            System.out.println("Checkout Step1 Title is Wrong");
        }

        //fill user information for checkout
        driver.findElement(By.cssSelector("[data-test=\"firstName\"]")).sendKeys("Regina");
        driver.findElement(By.cssSelector("[data-test=\"lastName\"]")).sendKeys("Guzovsky");
        driver.findElement(By.cssSelector("[data-test=\"postalCode\"]")).sendKeys("12345");
        driver.findElement(By.cssSelector("[data-test=\"continue\"]")).click();

        //check if url valid on checkout step 2
        String urlCheckoutStep2 =  "https://www.saucedemo.com/checkout-step-two.html";
        if(driver.getCurrentUrl().equals(urlCheckoutStep2)){
            System.out.println("Checkout Step2 URL Correct");
        }
        else{
            System.out.println("Checkout Step2 URL is Wrong");
        }

        //check if title valid on Checkout step2 url
        txtTitle =  driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        if(txtTitle.equals("Checkout: Overview")){
            System.out.println("Checkout Step2 Title is Correct");
        }
        else{
            System.out.println("Checkout Step2 Title is Wrong");
        }

        driver.findElement(By.cssSelector("[data-test=\"finish\"]")).click();

        String urlCheckoutStep3 =  "https://www.saucedemo.com/checkout-complete.html";
        if(driver.getCurrentUrl().equals(urlCheckoutStep2)){
            System.out.println("Checkout Complete URL Correct");
        }
        else{
            System.out.println("Checkout Complete URL is Wrong");
        }

        //check if title valid on Checkout step3 url
        txtTitle =  driver.findElement(By.cssSelector("[class=\"title\"]")).getText();
        if(txtTitle.equals("Checkout: Complete!")){
            System.out.println("Checkout Complete Title is Correct");
        }
        else{
            System.out.println("Checkout Complete Title is Wrong");
        }
        //check if info valid on Checkout step3 url
        String txtCheckoutComplete1 =  driver.findElement(By.cssSelector("[class=\"complete-header\"]")).getText();
        String txtCheckoutComplete2 =  driver.findElement(By.cssSelector("[class=\"complete-text\"]")).getText();
        s1 = "Thank you for your order!";
        s2 = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

        if(s1.equals((txtCheckoutComplete1)) && s2.equals((txtCheckoutComplete2)) ){
            System.out.println("Checkout Complete Text Correct");
        }
        else{
            System.out.println("Checkout Complete Text is Wrong");
        }

        //close connection and end tester
        driver.close();
        driver.quit();

    }
}
