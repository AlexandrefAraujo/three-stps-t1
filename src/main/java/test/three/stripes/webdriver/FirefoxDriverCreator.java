package test.three.stripes.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

class FirefoxDriverCreator implements WebDriverCreator {


    private WebDriver driver;

    @Override
    public WebDriver getDriver() {
        if (null == driver) {
            driver = new FirefoxDriver();
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
