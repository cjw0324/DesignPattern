// 자바프로그래밍2 1분반 24.12.03 32184682 최재우

import java.awt.*;
import java.util.List;

public class AlignmentState implements State {
    @Override
    public void applyBehavior(Boid boid, List<Boid> boids) {
        Point avgVelocity = new Point(0, 0); // 주변 Boid들의 평균 속도를 계산하기 위한 변수
        int count = 0; // 평균 계산에 포함된 Boid의 수

        // 주변 이웃 Boid들의 속도를 수집
        for (Boid other : boids) {
            // 현재 Boid가 아닌 다른 Boid 중에서 NEIGHBOR_DISTANCE 안에 있는 Boid만 포함
            if (other != boid && boid.getPosition().distance(other.getPosition()) < Boid.NEIGHBOR_DISTANCE) {
                avgVelocity.translate(other.getVelocity().x, other.getVelocity().y); // 속도 합산
                count++; // Boid 개수 증가
            }
        }

        // 평균 속도를 계산하고 Boid의 현재 속도와 비교하여 AlignmentForce를 적용
        if (count > 0) {
            avgVelocity.x /= count; // X 축 평균 속도 계산
            avgVelocity.y /= count; // Y 축 평균 속도 계산

            // 현재 Boid의 속도와 평균 속도의 차이를 계산하여 AlignmentForce로 사용
            Point alignmentForce = new Point(avgVelocity.x - boid.getVelocity().x, avgVelocity.y - boid.getVelocity().y);
            boid.applyForce(alignmentForce); // Boid에 AlignmentForce를 적용

            // 주변 Boid와 너무 가까운 경우 SeparationState로 전환
            for (Boid other : boids) {
                if (boid.getPosition().distance(other.getPosition()) < Boid.SEPARATION_DISTANCE) {
                    boid.setState(new SeparationState()); // 상태를 SeparationState로 변경
                    return; // 다른 로직을 실행하지 않고 종료
                }
            }
        }
    }

    @Override
    public String toString() {
        return "AlignmentState"; // 상태의 이름을 반환
    }
}
