import app.ProgramLauncherCommandApp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ProgramLauncherCommandApp app = new ProgramLauncherCommandApp();
            app.setVisible(true);
        });
    }
}