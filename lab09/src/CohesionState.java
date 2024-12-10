// 자바프로그래밍2 1분반 24.12.03 32184682 최재우

import java.awt.*;
import java.util.List;

public class CohesionState implements State {
    @Override
    public void applyBehavior(Boid boid, List<Boid> boids) {
        Point center = new Point(0, 0); // 주변 Boid들의 중심 위치를 계산하기 위한 변수
        int count = 0; // 중심 계산에 포함된 Boid의 수

        // 주변 Boid들의 위치를 수집하여 중심 위치 계산
        for (Boid other : boids) {
            // 현재 Boid가 아닌 다른 Boid 중에서 NEIGHBOR_DISTANCE 안에 있는 Boid만 포함
            if (other != boid && boid.getPosition().distance(other.getPosition()) < Boid.NEIGHBOR_DISTANCE) {
                center.translate(other.getPosition().x, other.getPosition().y); // 위치 합산
                count++; // 포함된 Boid의 개수 증가
            }
        }

        if (count > 0) {
            // 주변 Boid들의 중심 위치를 계산
            center.x /= count; // X 방향 평균 위치
            center.y /= count; // Y 방향 평균 위치

            // 현재 Boid 위치에서 중심 위치로 향하는 힘 계산
            Point cohesionForce = new Point(center.x - boid.getPosition().x, center.y - boid.getPosition().y);

            // Cohesion 강도를 조정하여 중심으로 이동하는 힘을 강화
            cohesionForce.x *= 2; // X 방향 강도 증가
            cohesionForce.y *= 2; // Y 방향 강도 증가

            boid.applyForce(cohesionForce); // Boid에 Cohesion force를 적용

            // 중심에 가까워졌을 경우 AlignmentState로 전환
            if (boid.getPosition().distance(center) < Boid.JOIN_THRESHOLD) {
                boid.setState(new AlignmentState()); // 상태를 AlignmentState로 변경
            }
        }
    }

    @Override
    public String toString() {
        return "CohesionState"; // 상태의 이름을 반환
    }
}
