package midterm.observer;

public class NewsMain {
    public static void main(String[] args) {
        NewsPaperSubject newsPaper = new NewsPaperSubject();
        YoutubeSubject youtubeSubject = new YoutubeSubject();
        Observer dkuStudent = new DKUObserver("최재우");
        Observer dkuStudent1 = new DKUObserver("김세은");

        newsPaper.addObserver(dkuStudent);
        newsPaper.addObserver(dkuStudent1);

        youtubeSubject.addObserver(dkuStudent);

        NewsPaper todayNews = new NewsPaper("속보! 10.20 넥토리얼 지원!", "사업pm 으로 지원 완료");
        Youtube youtube = new Youtube("shorts", "Nexon 과징금 200억", 89);

        newsPaper.setNews(todayNews);
        youtubeSubject.setYoutube(youtube);

    }
}
