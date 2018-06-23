package test.three.stripes.page.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.three.stripes.base.BasePage;
import test.three.stripes.page.store.sample.SamplePage;

import static test.three.stripes.log.ExtentReportLog.logger;

/**
 * This footer is the same for all pages
 */
public class FooterPage extends BasePage {

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#menu-item-54 a")
    private WebElement samplePageLink;

    public SamplePage gotoSamplePage(){
        samplePageLink.click();
        logger.info("clicking on Sample Page link");
        return new SamplePage(driver);
    }
}
