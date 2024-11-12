package app;

import programlaunchercommand.ProgramLauncherCommand;

import javax.swing.*;
import java.awt.*;
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
            JButton button = createButtonWithIcon(entry.getKey(),
                    entry.getValue()); // Trigger execute in invoker
                    // Add button to the GUI
            add(button);
        }

        // Add Undo button at the bottom
        JButton undoButton = new JButton("Undo Last Command");
        undoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                launcher.undoLastCommand(); // Trigger undo in invoker
            }
        });
        add(undoButton);
    }
}
