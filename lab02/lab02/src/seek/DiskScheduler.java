//Lab02, 자바프로그래밍2, 1분반, 2024-09-19, 최재우
package seek; // 디스크 스케줄러의 패키지 경로

import seek.seekStrategy.fcfs.FCFSSeekStrategy; // 기본 전략으로 FCFS(First Come First Serve) 전략을 임포트

// DiskScheduler 클래스는 디스크 스케줄링에 사용할 전략 패턴을 구현
public class DiskScheduler {

    // SeekStrategy 인터페이스 타입의 변수를 선언하여 다양한 탐색 전략을 사용
    private SeekStrategy strategy = null;

    // 기본 생성자에서 FCFS 전략을 기본으로 설정
    public DiskScheduler() {
        this.strategy = new FCFSSeekStrategy();
    }

    // setSeekStrategy 메서드는 전략을 동적으로 설정할 수 있도록 함
    public void setSeekStrategy(SeekStrategy strategy) {
        this.strategy = strategy;
    }

    // executeSeek 메서드는 현재 설정된 탐색 전략을 사용하여 탐색을 수행
    public void executeSeek(int[] queue, int start) {
        strategy.seek(queue, start);  // 현재 전략에 맞는 탐색 알고리즘을 실행
    }
}
