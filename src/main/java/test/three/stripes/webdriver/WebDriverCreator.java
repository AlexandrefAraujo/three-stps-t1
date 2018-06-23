package test.three.stripes.webdriver;

import org.openqa.selenium.WebDriver;

public interface WebDriverCreator {

    WebDriver getDriver();
    void quitDriver();
}
