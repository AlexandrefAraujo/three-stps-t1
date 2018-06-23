package test.three.stripes.page.store.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.three.stripes.base.BasePage;
import test.three.stripes.data.CommentForm;

import java.util.List;
import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SamplePage extends BasePage {

    public SamplePage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(commentTxtArea));
    }

    @FindBy(css = "div[class='comment_container group']")
    List<WebElement> commentContainer;


    @FindBy(css = "#comment")
    private WebElement commentTxtArea;

    @FindBy(css = "#author")
    private WebElement nameField;

    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(css = "#url")
    private WebElement webSiteField;

    @FindBy(css = "#submit")
    private WebElement postCommentButton;

    public SamplePage postComment(CommentForm comment){

        fillForm(comment);

        return this;
    }

    public ErrorPage postInvalidComment(CommentForm comment){

        fillForm(comment);

        return new ErrorPage(driver);
    }

    public SamplePage verifyCommentPosted(CommentForm comment){

        Optional<WebElement> lastComment = commentContainer.stream().reduce((f, s) -> s);

        assertTrue(lastComment.isPresent(),"Comment was successfully snet, but it is not present in the page");


        WebElement commentContainerLink = lastComment.get().findElement(By.cssSelector("cite[class=fn] a"));
        WebElement commentContainerText = lastComment.get().findElement(By.cssSelector("div[class=comment-body] p"));


        assertTrue(commentContainerLink.getAttribute("href").contains(comment.getWebSite()),
                "The user url in the comment is not the same sent");
        assertEquals(commentContainerText.getText().trim(), comment.getComment());

        return this;
    }

    private void fillForm(CommentForm c) {

        commentTxtArea.sendKeys(c.getComment());
        nameField.sendKeys(c.getName());
        emailField.sendKeys(c.getEmail());
        webSiteField.sendKeys(c.getWebSite());

        postCommentButton.click();
    }


}
