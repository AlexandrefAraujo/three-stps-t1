package test.three.stripes.data;

public class CommentForm{

    private final String name;
    private final String email;
    private final String webSite;
    private final String comment;

    public CommentForm(String name, String email, String webSite, String comment) {
        this.name = name;
        this.email = email;
        this.webSite = webSite;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getWebSite() {
        return webSite;
    }

    public String getComment() {
        return comment;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\nName: ");
        stringBuilder.append(name);
        stringBuilder.append("/");
        stringBuilder.append("Email: ");
        stringBuilder.append(email);
        stringBuilder.append("/");
        stringBuilder.append("Website: ");
        stringBuilder.append(webSite);
        stringBuilder.append("/");
        stringBuilder.append("Comment: ");
        stringBuilder.append(comment);

        return stringBuilder.toString();
    }
}
