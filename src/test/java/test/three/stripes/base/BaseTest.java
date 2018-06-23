package test.three.stripes.base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import test.three.stripes.webdriver.WebDriverManager;

import java.lang.reflect.Method;

import static test.three.stripes.log.ExtentReportLog.*;

public class BaseTest {

    private final String url = "http://store.demoqa.com";
    private WebDriverManager webDriverManager;
    public WebDriver driver;


    @BeforeClass
    public void setUp0(){
        initReport();

    }

    @AfterClass
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
