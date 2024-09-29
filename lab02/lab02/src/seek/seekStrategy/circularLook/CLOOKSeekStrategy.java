//Lab02, 자바프로그래밍2, 1분반, 2024-09-19, 최재우
package seek.seekStrategy.circularLook;

import seek.SeekStrategy;
import java.util.Arrays;

public class CLOOKSeekStrategy implements SeekStrategy {

    @Override
    public void seek(int[] queue, int start) {
        // 탐색 시작을 알리는 메시지 출력
        System.out.printf("C-LOOK Seek : ");

        // 요청 큐(queue)를 오름차순으로 정렬
        Arrays.sort(queue);

        // 결과를 저장할 배열과 인덱스를 초기화
        int[] result = new int[queue.length];
        int resultIndex = 0;
        int startIndex = 0;

        // 시작점보다 큰 첫 번째 요청의 인덱스를 찾음
        for (int i = 0; i < queue.length; i++) {
            if (queue[i] > start) {
                startIndex = i - 1; // 시작점 바로 이전의 요청을 가리킴
                break;
            }
        }

        // 시작점 바로 이전 요청에서 0 방향으로 이동 (작아지는 방향)
        for (int i = startIndex; i >= 0; i--) {
            result[resultIndex++] = queue[i];
        }

        // 가장 작은 요청으로 이동 후 다시 끝으로 이동 (오름차순 방향)
        for (int i = queue.length - 1; i >= startIndex + 1; i--) {
            result[resultIndex++] = queue[i];
        }

        // 결과 배열 출력
        for (int i = 0; i < resultIndex; i++) {
            System.out.printf("%d ", result[i]);
        }

        // 줄바꿈
        System.out.println(" ");
    }
}
