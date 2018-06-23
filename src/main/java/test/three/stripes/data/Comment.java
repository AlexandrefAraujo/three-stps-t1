package test.three.stripes.data;

import net.bytebuddy.utility.RandomString;

public class Comment {

    public static CommentForm VALID = new CommentForm("Alexandre", "a@e.com", "www.facebook.com",
            RandomString.make(10));

    public static CommentForm INVALID = new CommentForm("Alexandre", "withoutAT.com", "www.facebook.com",
            "comment with invalid email");

}
