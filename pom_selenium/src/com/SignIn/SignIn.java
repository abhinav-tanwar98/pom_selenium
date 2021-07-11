package com.SignIn;

import com.pom_selenium.PageInitialisation;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class SignIn extends PageInitialisation {
    public SignIn(WebDriver driver) throws IOException, ParseException {
        super(driver);
    }
    @FindBy(name = "email")
    static WebElement email;
    @FindBy(id = "passwd")
    static WebElement password;
    @FindBy(id = "SubmitLogin")
    static WebElement signIn;

    public static void setSignIn (String emailAddess, String pswrd){

            email.sendKeys(emailAddess);
            password.sendKeys(pswrd);
            signIn.click();

    }
}
