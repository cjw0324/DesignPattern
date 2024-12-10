// 자바프로그래밍2 1분반 24.12.03 32184682 최재우

import java.util.List;

// Boid의 상태를 정의하는 인터페이스
public interface State {
    // Boid의 행동을 적용하는 메서드
    void applyBehavior(Boid boid, List<Boid> boids);
}
