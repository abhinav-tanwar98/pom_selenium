package com.CreateAcc;

import com.pom_selenium.Main;
import com.pom_selenium.PageInitialisation;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;

public class CreateAcc extends PageInitialisation {
    public CreateAcc(WebDriver driver) throws IOException, ParseException {
        super(driver);
    }
    @FindBy(id = "email_create")
    WebElement emailAddress;
    @FindBy(id = "SubmitCreate")
    WebElement createAnAccount;
    @FindBy(id = "id_gender1")
    WebElement title;
    @FindBy(name = "customer_firstname")
    WebElement customerFirstName;
    @FindBy(name = "customer_lastname")
    WebElement customerLastName;
    @FindBy(id = "email")
    WebElement emailAdd;
    @FindBy(name = "passwd")
    WebElement password;
    @FindBy(id = "days")
    WebElement days;
    @FindBy(id = "months")
    WebElement months;
    @FindBy(id="years")
    WebElement years;
    @FindBy(name = "firstname")
    WebElement addFirstName;
    @FindBy(name = "lastname")
    WebElement addLastName;
    @FindBy(id = "address1")
    WebElement address;
    @FindBy(id = "city")
    WebElement city;
    @FindBy(id = "id_state")
    WebElement states;
    @FindBy(id = "postcode")
    WebElement postCode;
    @FindBy(id = "id_country")
    WebElement country;
    @FindBy(id = "phone_mobile")
    WebElement phoneNumber;
    @FindBy(id = "alias")
    WebElement addAlias;
    @FindBy(id = "submitAccount")
    WebElement register;

    public void setEmailAddress(String email){
        emailAddress.sendKeys(email);
    }
    public void clickCreateAnAccount(){
        createAnAccount.click();
    }
    public void clickTitle() {
        title.click();

    }
    public void setCustomerFirstName(String name){
        customerFirstName.sendKeys(name);
    }
    public void setCustomerLastName(String name){
        customerLastName.sendKeys(name);
    }
    public void setPassword(String password1){
        password.sendKeys(password1);
    }
    public void setEmail(String email){
        emailAdd.clear();
        emailAdd.sendKeys(email);
    }

    public void setDateOfBirth(String date,String month,String year){
        select(days,date);
        select(months,month);
        select(years,year);

    }
    public void setAddFirstName(String name){
        addFirstName.clear();
        addFirstName.sendKeys(name);
    }
    public void setAddLasttName(String name){
        addLastName.clear();
        addLastName.sendKeys(name);
    }
    public void setAddress(String add){
        address.sendKeys(add);
    }
    public void setCity(String city1){
        city.sendKeys(city1);
    }
    public void setStates(String val){
        select(states,val);
    }
    public void setPostCode(String code){
        postCode.sendKeys(code);
    }
    public void setCountry(String country1){
        Select coun=new Select(country);
        coun.selectByVisibleText(country1);
    }
    public void setPhoneNumber(String num){
        phoneNumber.sendKeys(num);
    }
    public void setAddressAlias(String add){
        addAlias.sendKeys(add);
    }
    public void clickRegister(){
        register.click();
    }



}
