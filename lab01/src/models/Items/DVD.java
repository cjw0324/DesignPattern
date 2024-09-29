//Lab01, 자바프로그래밍2, 1분반, 2024-09-14, 최재우
package models.Items;

import models.AbstractClass.LibraryItem;
import Interface.Streamable;

public class DVD extends LibraryItem implements Streamable {

    // DVD의 감독 이름을 저장하는 필드
    private String director;

    // DVD의 재생 시간을 저장하는 필드 (단위: 분)
    private int duration;

    // 생성자: DVD의 제목, 감독, 재생 시간을 초기화
    public DVD(String title, String director, int duration) {
        super(title);  // 상위 클래스 LibraryItem의 생성자를 호출하여 제목을 설정
        this.director = director;  // 감독 이름을 설정
        this.duration = duration;  // 재생 시간을 설정
    }

    // Streamable 인터페이스의 stream 메서드를 구현하여 DVD 스트리밍 기능 제공
    public void stream() {
        // DVD 스트리밍 중이라는 메시지를 출력
        System.out.println("DVD : " + getTitle() + " Streaming ...");
    }

    // ReportGenerator 인터페이스의 generateReport 메서드를 오버라이드하여 DVD에 대한 보고서 생성
    @Override
    public void generateReport() {
        // DVD의 제목, 감독, 재생 시간을 출력
        System.out.println("DVD : " + getTitle() + ", Director : " + director + ", Duration : " + duration + "'");
    }
}
