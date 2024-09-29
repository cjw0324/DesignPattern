//Lab02, 자바프로그래밍2, 1분반, 2024-09-19, 최재우
package seek.seekStrategy.scan;  // SCAN 알고리즘 패키지 경로 설정

import seek.SeekStrategy;  // SeekStrategy 인터페이스 임포트
import java.util.Arrays;   // 배열 정렬을 위한 Arrays 클래스 임포트

// SCANSeekStrategy 클래스는 SeekStrategy 인터페이스를 구현
public class SCANSeekStrategy implements SeekStrategy {

    // 인터페이스에 정의된 seek 메서드를 구현
    @Override
    public void seek(int[] queue, int start) {
        // SCAN 탐색의 시작을 나타내는 메시지 출력
        System.out.printf("SCAN Seek : ");

        // 요청된 트랙 번호들을 오름차순으로 정렬
        Arrays.sort(queue);

        // 결과를 저장할 배열과 인덱스를 초기화
        int[] result = new int[queue.length+1];  // 헤드가 0까지 가므로 +1 크기의 배열
        int resultIndex = 0;
        int startIndex = 0;

        // 현재 시작 위치에서 가까운 트랙의 인덱스를 찾음
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] > start) {
                startIndex = i - 1;  // 시작 위치 바로 이전의 인덱스
                break;
            }
        }

        // 헤드가 시작 위치에서 0까지 내려가는 과정
        for (int i = startIndex; i >= 0; i--) {
            result[resultIndex++] = queue[i];
        }

        // 0까지 이동한 후 다시 위로 올라가기 시작하므로 0 추가
        result[resultIndex++] = 0;

        // 0에서 가장 큰 트랙까지 이동
        for (int i = startIndex + 1; i < queue.length; i++) {
            result[resultIndex++] = queue[i];
        }

        // 탐색 결과 출력
        for (int i = 0; i < resultIndex; i++) {
            System.out.printf("%d ", result[i]);
        }

        // 줄바꿈
        System.out.println(" ");
    }
}
