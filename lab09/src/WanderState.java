// 자바프로그래밍2 1분반 24.12.03 32184682 최재우

import java.awt.*;
import java.util.List;
import java.util.Random;

public class WanderState implements State {
    private static final int MAX_FORCE = 1; // Boid가 랜덤으로 움직일 수 있는 최대 힘

    @Override
    public void applyBehavior(Boid boid, List<Boid> boids) {
        Random random = new Random();

        // Boid의 무작위 방황 동작을 위한 힘 생성
        int dx = random.nextInt(2 * MAX_FORCE + 1) - MAX_FORCE; // -MAX_FORCE ~ MAX_FORCE 사이의 X 방향 힘
        int dy = random.nextInt(2 * MAX_FORCE + 1) - MAX_FORCE; // -MAX_FORCE ~ MAX_FORCE 사이의 Y 방향 힘
        boid.applyForce(new Point(dx, dy)); // Boid에 힘 적용

        // 주변에 이웃 Boid가 있으면 CohesionState로 전환
        for (Boid other : boids) {
            if (other != boid && boid.getPosition().distance(other.getPosition()) < Boid.NEIGHBOR_DISTANCE) {
                boid.setState(new CohesionState()); // 상태를 CohesionState로 변경
                return; // 상태 변경 후 추가 로직 실행 방지
            }
        }
    }

    @Override
    public String toString() {
        return "WanderState"; // 상태의 이름을 반환
    }
}
