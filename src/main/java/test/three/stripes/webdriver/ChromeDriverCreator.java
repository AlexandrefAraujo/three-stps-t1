package test.three.stripes.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChromeDriverCreator implements WebDriverCreator{

    private static WebDriver driver;

    @Override
    public WebDriver getDriver() {
        if (null == driver) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return driver;
    }

    @Override
    public void quitDriver() {
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
}
