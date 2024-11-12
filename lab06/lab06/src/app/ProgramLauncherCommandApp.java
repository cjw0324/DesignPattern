//자바 프로그래밍2 1분반 32148682 최재우 24.11.12
package app;
import programlaunchercommand.ProgramLauncherCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ProgramLauncherCommandApp extends JFrame {
    // Invoker 객체로 명령을 실행하고 취소를 담당
    private ProgramLauncherCommandInvoker launcher = new ProgramLauncherCommandInvoker();
    // 명령어와 해당 명령 객체를 매핑한 Map
    private Map<String, ProgramLauncherCommand> commandMap;

    public ProgramLauncherCommandApp() {
        // 창의 제목 설정
        setTitle("Program Launcher with Icons");
        // 창의 크기 설정
        setSize(400, 400);
        // 창 닫을 때 프로그램 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 레이아웃을 세로로 구성
        setLayout(new GridLayout(0, 1));

        // JSON 파일에서 명령어를 로드하여 Map에 저장
        commandMap = ProgramLauncherCommandImporter.loadCommandsFromJson("commands.json");

        // 각 명령어에 대해 버튼을 생성하고 ActionListener 설정
        for (Map.Entry<String, ProgramLauncherCommand> entry : commandMap.entrySet()) {
            JButton button = createButtonWithIcon(entry.getKey(), entry.getValue());
            button.addActionListener(e -> {
                launcher.setCommand(entry.getValue()); // Invoker에 명령 설정
                launcher.executeCommand();             // 설정된 명령 실행
            });
            add(button); // 버튼을 GUI에 추가
        }

        // Undo 기능을 위한 버튼 생성
        JButton undoButton = new JButton("Undo Last Command");
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launcher.undoLastCommand(); // Invoker를 통해 마지막 명령 취소
            }
        });
        add(undoButton); // Undo 버튼을 GUI에 추가
    }

    // 명령어 이름과 아이콘을 가진 버튼을 생성하는 메서드
    private JButton createButtonWithIcon(String name, ProgramLauncherCommand command) {
        JButton button = new JButton(name); // 버튼에 이름 설정
        button.setIcon(new ImageIcon(command.getIcon())); // 아이콘 설정
        return button; // 버튼 반환
    }
}
