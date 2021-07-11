package com.home;

import com.pom_selenium.PageInitialisation;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.io.IOException;

public class home extends PageInitialisation {
    Actions ac;
    public TakesScreenshot ts;
    public home(WebDriver driver) throws IOException, ParseException {
        super(driver);
        this.ac=new Actions(driver);
        this.ts=(TakesScreenshot) driver;

    }
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/a")
    WebElement dresses;
    @FindBy(xpath = "//*[@id=\"block_top_menu\"]/ul/li[2]/ul/li[1]/a")
    WebElement casualDress;
    @FindBy(linkText = "Sign in")
    WebElement signIn;

    public void clickSignIn(){
        signIn.click();
    }


    public  void moveElementToBlouses() {
        //Main.takeScreenshot("1stPage");
        ac.moveToElement(dresses).moveToElement(casualDress).click().build().perform();


    }
}
