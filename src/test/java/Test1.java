import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.three.stripes.webdriver.WebDriverManager;


public class Test1 {

    private WebDriverManager webDriverManager;

    WebDriver driver;


    @BeforeMethod
    public void setUp(){
        webDriverManager = new WebDriverManager();
        driver = webDriverManager.getDriver();

    }

    @AfterMethod
    public void tearDown(){
        webDriverManager.quitDriver();
    }

    @Test
    public void bla(){
        System.out.println("asdfgh");
    }
}
