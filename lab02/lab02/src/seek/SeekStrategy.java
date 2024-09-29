//Lab02, 자바프로그래밍2, 1분반, 2024-09-19, 최재우
package seek;

// SeekStrategy 인터페이스 정의
// 모든 디스크 탐색 알고리즘이 이 인터페이스를 구현하여 일관된 방식으로 동작할 수 있도록 설계됨
public interface SeekStrategy {

    // queue: 디스크 요청 큐 (트랙 번호 배열)
    // start: 디스크 헤드의 시작 위치
    // 디스크 스케줄링 알고리즘이 이 메서드를 구현하여 각기 다른 방식으로 탐색을 수행
    void seek(int[] queue, int start);
}
