package test.three.stripes.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import test.three.stripes.webdriver.WebDriverManager;


public class BaseTest {

    private final String url = "http://store.demoqa.com";
    private WebDriverManager webDriverManager;

    public WebDriver driver;


    @BeforeMethod
    public void setUp(){
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        driver.navigate().to(url);
    }

    @AfterMethod
    public void tearDown(){
        webDriverManager.quitDriver();
    }

}
