package app;

import programlaunchercommand.ProgramLauncherCommand;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ProgramLauncherCommandApp extends JFrame {
    private ProgramLauncherCommandInvoker launcher = new ProgramLauncherCommandInvoker();
    private Map<String, ProgramLauncherCommand> commandMap;

    public ProgramLauncherCommandApp() {
        setTitle("Program Launcher with Icons");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        commandMap = ProgramLauncherCommandImporter.loadCommandsFromJson("commands.json");

        for (Map.Entry<String, ProgramLauncherCommand> entry : commandMap.entrySet()) {
            JButton button = createButtonWithIcon(entry.getKey(), entry.getValue());
            button.addActionListener(e -> {
                launcher.setCommand(entry.getValue());
                launcher.executeCommand();
            });
            add(button);
        }

        JButton undoButton = new JButton("Undo Last Command");
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launcher.undoLastCommand();
            }
        });
        add(undoButton);
    }

    private JButton createButtonWithIcon(String name, ProgramLauncherCommand command) {
        JButton button = new JButton(name);
        button.setIcon(new ImageIcon(command.getIcon())); // 아이콘을 설정
        return button;
    }

}
