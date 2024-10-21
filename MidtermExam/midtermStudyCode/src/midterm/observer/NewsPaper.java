package midterm.observer;

public class NewsPaper {
    private String title;
    private String body;

    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }
    public NewsPaper(String title, String body) {
        this.title = title;
        this.body = body;
    }
    @Override
    public String toString() {
        return "title : " + title + " , body : " + body;
    }
}
