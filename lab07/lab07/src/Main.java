//자바 프로그래밍2 1분반 32148682 최재우 24.11.12
import app.ProgramLauncherCommandApp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Swing의 이벤트 디스패치 스레드에서 GUI 애플리케이션을 실행
        SwingUtilities.invokeLater(() -> {
            // ProgramLauncherCommandApp 인스턴스를 생성하여 실행
            ProgramLauncherCommandApp app = new ProgramLauncherCommandApp();
            app.setVisible(true); // 애플리케이션 창을 화면에 표시
        });
    }
}
