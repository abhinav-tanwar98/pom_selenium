package com.pom_selenium;

import com.AddToCart.AddToCartPage;
import com.CreateAcc.CreateAcc;
import com.DressPage.DressPage;
import com.SignIn.SignIn;
import com.home.home;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {
    public static WebDriver driver;

    public static EventFiringWebDriver eventWebdriver;
    public static listener eventListener;

    public static void eventfiringwebdriversetup(){
        eventWebdriver=new EventFiringWebDriver(driver);
        eventListener=new listener();
        eventWebdriver.register(eventListener);
        eventWebdriver.manage().window().maximize();
        eventWebdriver.get("http://automationpractice.com/index.php");
    }

    public static void main(String[] args) throws IOException, ParseException, JSONException {

        PageInitialisation pi=new PageInitialisation(eventWebdriver);
        if(((String) pi.jsonobj.get("browser")).equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options=new ChromeOptions();
//            options.addArguments("--headless");
            driver=new ChromeDriver(options);
        }
        else if(((String) pi.jsonobj.get("browser")).equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options=new FirefoxOptions();
            options.addArguments("--headless");
            driver=new FirefoxDriver(options);
        }
        eventfiringwebdriversetup();//
        CreateAcc ca=new CreateAcc(eventWebdriver);
        home hm=new home(eventWebdriver);

        DressPage dress=new DressPage(eventWebdriver);
        AddToCartPage addcart=new AddToCartPage(eventWebdriver);
        SignIn signin=new SignIn(eventWebdriver);

        eventWebdriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

//        hm.clickSignIn();
        hm.moveElementToBlouses();
        dress.scroll();
        dress.clickOnBlouse();

        addcart.scroll();
        addcart.clickOnAddToCart();
        addcart.clickProceedToCheckout();
        addcart.scrollContinueToCheckout();
        addcart.clickContinueToCheckout();

        Map address = ((Map)pi.jsonobj.get("dob"));
        Iterator<Map.Entry> itr1 = address.entrySet().iterator();
        HashMap<String, String> dob = new HashMap<String, String>();
        while (itr1.hasNext()) {
            Map.Entry pair = itr1.next();
            dob.put((String) pair.getKey(),(String) pair.getValue());
        }

        ca.setEmailAddress((String) pi.jsonobj.get("emailAddress"));
        ca.clickCreateAnAccount();
//        signin.setSignIn((String) pi.jsonobj.get("emailAddress"),(String) pi.jsonobj.get("password"));
        ca.clickTitle();
        ca.setCustomerFirstName((String) pi.jsonobj.get("firstName"));
        ca.setCustomerLastName((String) pi.jsonobj.get("lastName"));
        ca.setEmail((String) pi.jsonobj.get("emailAddress"));
        ca.setPassword((String) pi.jsonobj.get("password"));
        ca.setDateOfBirth((String) pi.jsonobj.get("date"),(String) pi.jsonobj.get("month"),(String) pi.jsonobj.get("year"));
        ca.setAddFirstName((String) pi.jsonobj.get("firstName"));
        ca.setAddLasttName((String) pi.jsonobj.get("lastName"));
        ca.setAddress((String) pi.jsonobj.get("address"));
        ca.setCity((String) pi.jsonobj.get("city"));
        ca.setStates((String) pi.jsonobj.get("state"));
        ca.setPostCode((String) pi.jsonobj.get("postCode"));
        ca.setCountry((String) pi.jsonobj.get("country"));
        ca.setPhoneNumber((String) pi.jsonobj.get("phoneNum"));
        ca.setAddressAlias((String) pi.jsonobj.get("AddressAlias"));
//        ca.clickRegister();
//        signin.setSignIn((String) pi.jsonobj.get("emailAddress"),(String) pi.jsonobj.get("password"));

    }
}
