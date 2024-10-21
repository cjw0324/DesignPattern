package midterm.observer;

public class Youtube {
    private String form;
    private String title;
    private int length;

    public Youtube(String form, String title, int length) {
        this.form = form;
        this.title = title;
        this.length = length;
    }

    @Override
    public String toString() {
        return "Youtube 영상 :" + form + ", 제목 : " + title + ", 영상 길이 " + Integer.toString(length);
    }
}
