// 자바프로그래밍2 1분반 24.12.03 32184682 최재우

import java.awt.*;
import java.util.List;

public class SeparationState implements State {
    @Override
    public void applyBehavior(Boid boid, List<Boid> boids) {
        Point steer = new Point(0, 0); // Separation force를 계산하기 위한 변수
        int count = 0; // Separation 계산에 포함된 Boid의 수

        // 주변 Boid와의 거리를 계산하여 Separation force 적용
        for (Boid other : boids) {
            int distance = (int) boid.getPosition().distance(other.getPosition());
            if (other != boid && distance < Boid.SEPARATION_DISTANCE) { // Boid가 가까이 있는 경우
                if (distance == 0) distance = 1; // 거리 값이 0인 경우 나눗셈 오류 방지

                // 다른 Boid와 반대 방향으로 힘을 계산
                Point diff = new Point(boid.getPosition().x - other.getPosition().x, boid.getPosition().y - other.getPosition().y);
                steer.translate(diff.x / distance, diff.y / distance); // 거리 기반으로 힘 계산
                count++; // 포함된 Boid의 개수 증가
            }
        }

        if (count > 0) {
            steer.x /= count; // X 방향 평균 Separation force
            steer.y /= count; // Y 방향 평균 Separation force

            // Separation 강도를 약화하여 부드러운 동작 보장
            steer.x /= 2; // X 방향 강도 조정
            steer.y /= 2; // Y 방향 강도 조정

            boid.applyForce(steer); // Boid에 Separation force 적용

            // Separation 상태에서 멀어졌으면 WanderState로 전환
            boolean isSeparated = true;
            for (Boid other : boids) {
                if (boid.getPosition().distance(other.getPosition()) < Boid.SEPARATION_DISTANCE) { // 가까운 Boid가 있으면 Separation 유지
                    isSeparated = false;
                    break;
                }
            }
            if (isSeparated) {
                boid.setState(new WanderState()); // WanderState로 상태 전환
            }
        }
    }

    @Override
    public String toString() {
        return "SeparationState"; // 상태의 이름을 반환
    }
}
