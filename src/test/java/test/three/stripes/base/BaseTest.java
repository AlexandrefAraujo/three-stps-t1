package test.three.stripes.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import test.three.stripes.webdriver.WebDriverManager;

import java.lang.reflect.Method;

import static test.three.stripes.log.ExtentReportLog.*;

public class BaseTest {

    private final String url = "http://store.demoqa.com";
    private WebDriverManager webDriverManager;
    public WebDriver driver;


    @BeforeSuite
    public void setUp0(){
        initReport();

    }

    @AfterSuite
    public void tearDown0(){
        flushReport();
    }

    @BeforeMethod
    public void setUp(Method method){
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();
        driver.navigate().to(url);
        initTestMethod(method);
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        System.out.println("instance "+result.getInstanceName());
        System.out.println("name "+result.getName());

        webDriverManager.quitDriver();
        setStatus(result);
    }

}
