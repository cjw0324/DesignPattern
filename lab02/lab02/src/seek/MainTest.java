//Lab02, 자바프로그래밍2, 1분반, 2024-09-19, 최재우
package seek;

import seek.seekStrategy.circularLook.CLOOKSeekStrategy;
import seek.seekStrategy.circularScan.CSCANSeekStrategy;
import seek.seekStrategy.fcfs.FCFSSeekStrategy;
import seek.seekStrategy.scan.SCANSeekStrategy;
import seek.seekStrategy.sstf.SSTFSeekStrategy;

public class MainTest {

    // MainTest 생성자에서 디스크 스케줄링 테스트를 실행
    public MainTest() {
        // 탐색할 큐를 정의 (디스크 요청 순서)
        int[] queue = { 70, 153, 24, 57, 140, 15, 115, 80, 85 };
        // 시작 헤드 위치
        int start = 43;

        // 디스크 스케줄러 객체 생성 (기본 탐색 전략은 FCFS로 설정)
        DiskScheduler scheduler = new DiskScheduler();

        // 사용할 탐색 전략 배열 (FCFS, SSTF, SCAN, CSCAN, CLOOK 순서로 선언)
        SeekStrategy[] strategies = {
                new FCFSSeekStrategy(),
                new SSTFSeekStrategy(),
                new SCANSeekStrategy(),
                new CSCANSeekStrategy(),
                new CLOOKSeekStrategy()
        };

        // 모든 탐색 전략을 순차적으로 실행
        for (SeekStrategy strategy : strategies) {
            // 현재 탐색 전략을 설정
            scheduler.setSeekStrategy(strategy);
            // 설정된 탐색 전략을 사용하여 큐와 시작점을 전달해 탐색을 실행
            scheduler.executeSeek(queue, start);
        }
    }
}
