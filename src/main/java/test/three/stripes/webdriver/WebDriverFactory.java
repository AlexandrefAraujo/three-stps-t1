package test.three.stripes.webdriver;


import org.openqa.selenium.WebDriver;

enum WebDriverFactory implements WebDriverCreator{

    FIREFOX(new FirefoxDriverCreator());


    private WebDriverCreator driver;

    WebDriverFactory(WebDriverCreator driver) {
        this.driver = driver;
    }

    @Override
    public WebDriver getDriver() {
        return this.driver.getDriver();
    }
    @Override
    public void quitDriver(){
        this.driver.quitDriver();
    }


}
