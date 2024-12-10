// 자바프로그래밍2 1분반 24.12.03 32184682 최재우

import javax.swing.*;

public class FlockSimulationApp extends JFrame {
    public FlockSimulationApp() {
        super("2D Flock of Birds Simulation"); // 창의 제목 설정
        add(new FlockPanel()); // FlockPanel을 프레임에 추가
        pack(); // 컴포넌트 크기에 맞게 창 크기 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창 닫기 동작 설정
        setLocationRelativeTo(null); // 창을 화면 중앙에 배치
        setVisible(true); // 창을 화면에 표시
    }

    public static void main(String[] args) {
        new FlockSimulationApp(); // 시뮬레이션 애플리케이션 실행
    }
}
