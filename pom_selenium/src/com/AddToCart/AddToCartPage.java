package com.AddToCart;

import com.pom_selenium.PageInitialisation;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddToCartPage extends PageInitialisation {
    JavascriptExecutor js;
    public AddToCartPage(WebDriver driver) throws IOException, ParseException {
        super(driver);
        this.js=(JavascriptExecutor) driver;
    }
    @FindBy(css = ".top-hr")
    WebElement scrollUptoAddToCart;
    @FindBy(id ="color_11")
    WebElement optionBlack;
    @FindBy(id = "color_8")
    WebElement optionWhite;
    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button")
    WebElement addToCart;
    @FindBy(xpath = "//div[@id='layer_cart']//a")
    WebElement proceedToCheckOut;
    @FindBy(css = ".step_current.first")
    WebElement scrollUptoContinueToCheckout;
    @FindBy(css = ".button.btn.btn-default.standard-checkout.button-medium[title=\"Proceed to checkout\"]")
    WebElement continueToCheckout;
    public void scroll(){
        js.executeScript("arguments[0].scrollIntoView();", scrollUptoAddToCart);
    }

    public void clickOnAddToCart(){
        addToCart.click();
    }

    public void clickProceedToCheckout(){ proceedToCheckOut.click();}
    public void scrollContinueToCheckout(){
        js.executeScript("arguments[0].scrollIntoView();",scrollUptoContinueToCheckout);
    }
    @Test
    public void clickContinueToCheckout(){continueToCheckout.click();}
}
