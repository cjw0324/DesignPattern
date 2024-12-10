// 자바프로그래밍2 1분반 24.12.03 32184682 최재우

import java.awt.*;
import java.util.List;

public class AvoidanceState implements State {
    private static final int AVOIDANCE_DISTANCE = 50; // 장애물과의 회피 거리

    private Point obstacle; // 장애물 위치

    public AvoidanceState(Point obstacle) {
        this.obstacle = obstacle; // 장애물 위치를 초기화
    }

    @Override
    public void applyBehavior(Boid boid, List<Boid> boids) {
        // 현재 Boid와 장애물 사이의 거리 계산
        int distance = (int) boid.getPosition().distance(obstacle);

        if (distance < AVOIDANCE_DISTANCE) {
            // 장애물 반대 방향으로 힘을 가하기 위해 벡터 계산
            Point diff = new Point(boid.getPosition().x - obstacle.x, boid.getPosition().y - obstacle.y);

            if (distance > 0) { // 거리 값이 0이 아닐 경우 벡터를 거리로 정규화
                diff.x /= distance;
                diff.y /= distance;
            }

            // 회피 강도를 조정
            diff.x *= 5; // X축 회피 강도
            diff.y *= 5; // Y축 회피 강도

            // Boid에 회피 힘 적용
            boid.applyForce(diff);
        } else {
            // 장애물에서 충분히 멀어진 경우 WanderState로 전환
            boid.setState(new WanderState());
        }
    }

    @Override
    public String toString() {
        return "AvoidanceState"; // 상태의 이름을 반환
    }
}
