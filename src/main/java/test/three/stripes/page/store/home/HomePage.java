package test.three.stripes.page.store.home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.three.stripes.base.BasePage;
import test.three.stripes.page.store.FooterPage;

/**
 *  I'm creating just the necessary objects for the challenge.
 */
public class HomePage extends BasePage {

    @FindBy(css = "#header")
    private WebElement header;

    @FindBy(css = "#footer_nav")
    private WebElement footer;

    public HomePage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(header));
    }

    //TODO map remaining elements

    public FooterPage scrollToFooter(){
        wait.until(ExpectedConditions.visibilityOf(footer));
        actions.moveToElement(footer);
        return new FooterPage(this.driver);
    }
}
