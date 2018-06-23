package test.three.stripes.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * It was not tested, I'm working on Linux.
 */
public class IEDriverCreator implements WebDriverCreator{

    private static WebDriver driver;

    @Override
    public WebDriver getDriver() {
        if (null == driver) {
            driver = new InternetExplorerDriver();
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
