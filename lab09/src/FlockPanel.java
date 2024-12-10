// 자바프로그래밍2 1분반 24.12.03 32184682 최재우

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FlockPanel extends JPanel {
    private static final int PANEL_WIDTH = 800; // 패널의 너비
    private static final int PANEL_HEIGHT = 600; // 패널의 높이
    private static final int NUM_BOIDS = 100; // Boid의 개수
    private static final int UPDATE_INTERVAL = 50; // Boid 업데이트 주기(ms)
    private Point obstacle; // 장애물의 위치

    private List<Boid> boids; // Boid의 리스트

    public FlockPanel() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT)); // 패널 크기 설정
        setBackground(Color.WHITE); // 배경색 설정

        // 장애물 초기화 (패널 중앙)
        obstacle = new Point(PANEL_WIDTH / 2, PANEL_HEIGHT / 2);

        // Boid 리스트 초기화
        boids = new ArrayList<>();
        for (int i = 0; i < NUM_BOIDS; i++) {
            boids.add(new Boid(PANEL_WIDTH, PANEL_HEIGHT)); // Boid 생성 및 추가
        }

        // 타이머를 사용하여 Boid 업데이트
        new Timer(UPDATE_INTERVAL, e -> {
            updateBoids(); // Boid 상태와 위치 업데이트
            repaint(); // 패널 다시 그리기
        }).start();
    }

    // Boid 상태와 위치를 업데이트
    private void updateBoids() {
        for (Boid boid : boids) {
            boid.updateStateBehavior(boids, obstacle); // Boid 상태 업데이트 및 장애물 전달
            boid.update(); // Boid 위치 업데이트
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // 기존 컴포넌트 그리기

        // 장애물 그리기
        g.setColor(Color.RED); // 장애물 색상 설정
        g.fillOval(obstacle.x - 10, obstacle.y - 10, 20, 20); // 장애물 위치와 크기 설정

        // Boid 그리기
        for (Boid boid : boids) {
            boid.draw(g); // 각 Boid를 화면에 그리기
            System.out.println(boid); // Boid의 현재 상태를 콘솔에 출력
        }
    }
}
