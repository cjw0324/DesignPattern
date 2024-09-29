//Lab02, 자바프로그래밍2, 1분반, 2024-09-19, 최재우
package seek.seekStrategy.fcfs;  // FCFS 알고리즘 패키지 경로 설정

import seek.SeekStrategy;  // SeekStrategy 인터페이스 임포트

// FCFSSeekStrategy 클래스는 SeekStrategy 인터페이스를 구현
public class FCFSSeekStrategy implements SeekStrategy {

    // 인터페이스에 정의된 seek 메서드를 구현
    @Override
    public void seek(int[] queue, int start) {
        // FCFS 탐색의 시작을 나타내는 메시지 출력
        System.out.printf("FCFS Seek : ");

        // FCFS(First Come First Serve) 방식으로 요청 큐에 들어온 순서대로 처리
        for (int q : queue) {
            // 각 요청된 트랙을 출력
            System.out.printf("%d ", q);
        }

        // 출력 완료 후 줄바꿈
        System.out.printf("\n");
    }
}
