package com.pom_selenium;

import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PageInitialisation {
    public PageInitialisation(WebDriver driver) throws IOException, ParseException {
        PageFactory.initElements(driver,this);

    }
    JSONParser jsonParser=new JSONParser();
    FileReader reader=new FileReader(".\\jsonfiles\\json.json");
    Object obj=jsonParser.parse(reader);
    JSONObject jsonobj=(JSONObject) obj;


    public void select(WebElement element, String data){
        Select option=new Select(element);
        option.selectByValue(data);
    }


    //public static WebDriver driver;
    //Actions ac=new Actions(driver);
    //JavascriptExecutor js = (JavascriptExecutor) driver;
}
