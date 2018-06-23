package test.three.stripes.webdriver;

import org.openqa.selenium.WebDriver;

public class WebDriverManager implements WebDriverCreator{


    private final WebDriverFactory webDriverInstance;

    public WebDriverManager() {

        WebDriverProperties properties = new WebDriverProperties().loadContext();

        System.setProperty(properties.webDriverSytemProperty, properties.webDriverPath);

        webDriverInstance = WebDriverFactory.valueOf(properties.browser);

    }


    @Override
    public WebDriver getDriver() {
      return webDriverInstance.getDriver();
    }

    @Override
    public void quitDriver() {
        webDriverInstance.quitDriver();
    }
}
