package com.DressPage;

import com.pom_selenium.PageInitialisation;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import java.io.IOException;

public class DressPage extends PageInitialisation {
    JavascriptExecutor js;
    public DressPage(WebDriver driver) throws IOException, ParseException {
        super(driver);
        this.js=(JavascriptExecutor) driver;
    }
    @FindBy(xpath = "//*[@id=\"center_column\"]/div[2]/div[2]")
    WebElement scrollUptoDress;
    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[2]/h5/a")
    WebElement locateToBlouse;

    public void scroll() {
        js.executeScript("arguments[0].scrollIntoView();", scrollUptoDress);
    }

    public void clickOnBlouse(){
        locateToBlouse.click();
    }


}
