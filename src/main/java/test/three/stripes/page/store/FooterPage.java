package test.three.stripes.page.store;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import test.three.stripes.base.BasePage;
import test.three.stripes.page.store.sample.SamplePage;
/**
 * This class represents the static footer in the web page and should be used to just with elements in the footer.
 */
public class FooterPage extends BasePage {

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#menu-item-54 a")
    private WebElement samplePageLink;

    public SamplePage gotoSamplePage(){
        samplePageLink.click();
        return new SamplePage(driver);
    }
}
