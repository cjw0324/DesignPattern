//Lab02, 자바프로그래밍2, 1분반, 2024-09-19, 최재우
package seek.seekStrategy.sstf;  // SSTF 알고리즘에 대한 패키지 경로 설정

import seek.SeekStrategy;  // SeekStrategy 인터페이스 임포트

// SSTFSeekStrategy 클래스는 SeekStrategy 인터페이스를 구현
public class SSTFSeekStrategy implements SeekStrategy {

    // SeekStrategy 인터페이스에 정의된 seek 메서드를 구현
    @Override
    public void seek(int[] queue, int start) {
        System.out.printf("SSTF Seek : ");

        // 각 트랙이 방문되었는지를 기록하는 배열
        boolean[] visited = new boolean[queue.length];
        // 최종 탐색 순서를 저장할 배열
        int[] result = new int[queue.length];
        // 탐색 시작점 설정
        int current = start;

        // 모든 요청을 탐색할 때까지 반복
        for (int i = 0; i < queue.length; i++) {
            // 가장 가까운 트랙의 인덱스와 거리를 저장할 변수
            int closest = -1;
            int closestDistance = Integer.MAX_VALUE;

            // 모든 요청된 트랙을 순회하여 가장 가까운 트랙을 찾음
            for (int j = 0; j < queue.length; j++) {
                // 아직 방문하지 않았고, 현재 헤드 위치에서 가장 가까운 트랙을 찾음
                if (!visited[j] && CalcDistance(queue[j], current) < closestDistance) {
                    closest = j;
                    closestDistance = CalcDistance(queue[j], current);
                }
            }

            // 가장 가까운 트랙을 방문 처리하고, 결과 배열에 추가
            visited[closest] = true;
            result[i] = queue[closest];
            // 현재 헤드 위치를 가장 가까운 트랙으로 갱신
            current = queue[closest];
        }

        // 결과 배열에 저장된 탐색 순서를 출력
        for (int num : result) {
            System.out.printf("%d ", num);
        }
        System.out.println(" ");
    }

    // 두 숫자 사이의 절대 거리를 계산하는 헬퍼 메서드
    public static int CalcDistance(int num1, int num2) {
        return Math.abs(num1 - num2);  // 절대값을 이용해 거리를 계산
    }
}


