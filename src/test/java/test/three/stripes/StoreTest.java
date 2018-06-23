package test.three.stripes;

import org.testng.annotations.Test;
import test.three.stripes.base.BaseTest;
import test.three.stripes.data.Comment;
import test.three.stripes.page.store.home.HomePage;

public class StoreTest extends BaseTest {


    @Test
    public void testComment(){


        new HomePage(driver)
                .scrollToFooter()
                .gotoSamplePage()
                .postInvalidComment(Comment.INVALID)
                .verifyInvalidEmail()
                .backToSamplePage()
                .postComment(Comment.VALID)
                .verifyCommentPosted(Comment.VALID);
    }
}
