//Lab02, 자바프로그래밍2, 1분반, 2024-09-19, 최재우
package seek.seekStrategy.circularScan;

import seek.SeekStrategy;
import java.util.Arrays;

public class CSCANSeekStrategy implements SeekStrategy {

    @Override
    public void seek(int[] queue, int start) {
        // C-SCAN 탐색 시작 메시지 출력
        System.out.printf("C-SCAN Seek : ");

        // 요청 큐(queue)를 오름차순으로 정렬
        Arrays.sort(queue);

        // 탐색 결과를 저장할 배열. 끝과 처음을 포함하기 때문에 2개의 공간을 더 추가
        int[] result = new int[queue.length + 2];
        int resultIndex = 0;
        int startIndex = 0;

        // 시작 트랙보다 큰 요청을 찾고 그 이전 인덱스의 값을 startIndex로 설정
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] > start) {
                startIndex = i - 1;
                break;
            }
        }

        // 첫 번째 탐색: 시작점 이전의 요청들을 작은 값에서부터 처리 (작아지는 방향)
        for (int i = startIndex; i >= 0; i--) {
            result[resultIndex++] = queue[i];
        }

        // 끝으로 이동 후, 트랙의 마지막(199)과 처음(0)을 방문
        result[resultIndex++] = 0;    // 첫 번째 트랙
        result[resultIndex++] = 199;  // 마지막 트랙

        // 두 번째 탐색: 남은 큰 값들을 처리
        for (int i = queue.length - 1; i >= startIndex + 1; i--) {
            result[resultIndex++] = queue[i];
        }

        // 결과 출력
        for (int i = 0; i < resultIndex; i++) {
            System.out.printf("%d ", result[i]);
        }

        // 줄바꿈 출력
        System.out.println(" ");
    }
}
