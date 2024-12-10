// 자바프로그래밍2 1분반 24.12.03 32184682 최재우

import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Boid {
    public static final int SPEED = 3; // Boid의 최대 속도
    public static final int SEPARATION_DISTANCE = 20; // Separation 상태에서의 최소 거리
    public static final int NEIGHBOR_DISTANCE = 50; // Cohesion과 Alignment 상태에서의 이웃 거리
    public static final int JOIN_THRESHOLD = 15; // Cohesion에서 Alignment로 전환되는 거리

    private Point position; // Boid의 현재 위치
    private Point velocity; // Boid의 현재 속도
    private int panelWidth; // 패널 너비
    private int panelHeight; // 패널 높이
    private Random random; // 랜덤 값 생성기

    private State state; // Boid의 현재 상태
    private int id; // Boid의 고유 ID
    private static int count = 0; // Boid 객체의 생성 개수

    public Boid(int panelWidth, int panelHeight) {
        this.panelWidth = panelWidth;
        this.panelHeight = panelHeight;
        this.random = new Random();

        this.id = ++count; // Boid의 고유 ID 생성
        this.state = new WanderState(); // 초기 상태를 WanderState로 설정

        // Boid의 초기 위치 설정
        position = new Point(random.nextInt(panelWidth), random.nextInt(panelHeight));

        // 속도가 (0, 0)이 되지 않도록 초기화
        do {
            velocity = new Point(random.nextInt(2 * SPEED) - SPEED, random.nextInt(2 * SPEED) - SPEED);
        } while (velocity.x == 0 || velocity.y == 0); // 속도값이 (0, 0)이면 다시 생성
    }

    // Boid가 주변 Boid와 상호작용하는 로직
    public void flock(List<Boid> boids) {
        Point separation = separate(boids); // Separation force 계산
        Point alignment = align(boids); // Alignment force 계산
        Point cohesion = cohere(boids); // Cohesion force 계산

        // 세 가지 force를 가중치와 함께 결합하여 최종 속도 결정
        velocity.translate((int)(separation.x * 1.5 + alignment.x * 1.0 + cohesion.x * 1.0),
                (int)(separation.y * 1.5 + alignment.y * 1.0 + cohesion.y * 1.0));

        // 속도 제한
        limitSpeed();
    }

    // Separation force를 계산하여 가까운 Boid들과의 충돌을 방지
    private Point separate(List<Boid> boids) {
        Point steer = new Point(0, 0);
        int count = 0;

        for (Boid other : boids) {
            int distance = (int) position.distance(other.position);
            if (other != this && distance > 0 && distance < SEPARATION_DISTANCE) {
                Point diff = new Point(position.x - other.position.x, position.y - other.position.y);
                steer.translate(diff.x / distance, diff.y / distance); // 거리 기반으로 force 계산
                count++;
            }
        }

        if (count > 0) {
            steer.x /= count; // X 방향 평균 force
            steer.y /= count; // Y 방향 평균 force
        }
        return steer; // 최종 force 반환
    }

    // Alignment force를 계산하여 주변 Boid의 방향에 맞춤
    private Point align(List<Boid> boids) {
        Point avgVelocity = new Point(0, 0);
        int count = 0;

        for (Boid other : boids) {
            if (other != this && position.distance(other.position) < NEIGHBOR_DISTANCE) {
                avgVelocity.translate(other.velocity.x, other.velocity.y); // 속도 합산
                count++;
            }
        }

        if (count > 0) {
            avgVelocity.x /= count; // X 방향 평균 속도
            avgVelocity.y /= count; // Y 방향 평균 속도
            avgVelocity.translate(-velocity.x, -velocity.y); // 현재 속도와의 차이 계산
        }
        return avgVelocity; // 최종 force 반환
    }

    // Cohesion force를 계산하여 주변 Boid의 중심으로 이동
    private Point cohere(List<Boid> boids) {
        Point center = new Point(0, 0);
        int count = 0;

        for (Boid other : boids) {
            if (other != this && position.distance(other.position) < NEIGHBOR_DISTANCE) {
                center.translate(other.position.x, other.position.y); // 위치 합산
                count++;
            }
        }

        if (count > 0) {
            center.x /= count; // X 방향 중심 계산
            center.y /= count; // Y 방향 중심 계산
            center.translate(-position.x, -position.y); // 현재 위치와의 차이 계산
        }
        return center; // 최종 force 반환
    }

    // Boid에 힘을 적용
    public void applyForce(Point force) {
        // 속도가 (0, 0)으로 멈추지 않도록 기본값 추가
        if (velocity.x == 0 && velocity.y == 0) {
            velocity.x += 1;
            velocity.y += 1;
        }
        velocity.translate(force.x, force.y); // force를 속도에 적용
    }

    // Boid의 속도를 최대 속도로 제한
    private void limitSpeed() {
        double magnitude = Math.sqrt(velocity.x * velocity.x + velocity.y * velocity.y);
        if (magnitude > SPEED) {
            velocity.x = (int) ((velocity.x / magnitude) * SPEED);
            velocity.y = (int) ((velocity.y / magnitude) * SPEED);
        }
    }

    // Boid의 위치를 업데이트
    public void update() {
        // 화면 경계를 넘어가면 반대쪽으로 이동
        if (position.x < 0) position.x = panelWidth;
        else if (position.x > panelWidth) position.x = 0;
        if (position.y < 0) position.y = panelHeight;
        else if (position.y > panelHeight) position.y = 0;
        position.translate(velocity.x, velocity.y); // 위치 업데이트
    }

    // Boid를 화면에 삼각형으로 그리기
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;

        double angle = Math.atan2(velocity.y, velocity.x); // 이동 방향 계산

        g2d.translate(position.x, position.y);
        g2d.rotate(angle); // Boid 방향 회전

        int[] xPoints = {0, -10, -10}; // 삼각형 X 좌표
        int[] yPoints = {0, -5, 5}; // 삼각형 Y 좌표
        g2d.setColor(Color.BLUE); // Boid 색상 설정
        g2d.fillPolygon(xPoints, yPoints, 3); // Boid를 삼각형으로 그림

        g2d.rotate(-angle);
        g2d.translate(-position.x, -position.y);
    }

    // Boid의 상태를 업데이트
    public void updateStateBehavior(List<Boid> boids, Point obstacle) {
        // 장애물 근처로 접근하면 AvoidanceState로 전환
        if (this.getPosition().distance(obstacle) < 60 && !(state instanceof AvoidanceState)) {
            this.setState(new AvoidanceState(obstacle));
        } else {
            state.applyBehavior(this, boids); // 현재 상태의 동작 수행
        }
    }

    public Point getPosition() { return position; } // Boid의 위치 반환
    public Point getVelocity() { return velocity; } // Boid의 속도 반환

    public Boid setState(State state) {
        this.state = state; // Boid의 상태 설정
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                ", position='" + getPosition() + "'" +
                ", velocity='" + getVelocity() + "'" +
                "}";
    }
}
