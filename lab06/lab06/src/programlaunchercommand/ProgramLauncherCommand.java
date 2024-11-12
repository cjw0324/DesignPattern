package programlaunchercommand;

import java.io.IOException;

public class ProgramLauncherCommand implements IProgramLauncherCommand {

    private String executable;
    private String icon;
    private Process process;

    public ProgramLauncherCommand(String executable, String icon) {
        this.executable = executable;
        this.icon = icon;
    }


    @Override
    public void execute() {
        // 실행
        try {
            ProcessBuilder pb;
            if (executable.split(" ").length > 1) {
                pb = new ProcessBuilder(executable.split(" "));
            }
            else {
                // 단일 명령인 경우
                pb = new ProcessBuilder(executable);
            }
            process = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void undo() {
        if (process != null) {
            // Windows에서 Notepad와 Edge를 강제로 종료하는 추가 로직
            try {
                System.out.println("undo start");
                if (executable.contains("notepad")) {
                    System.out.println("notepad 종료");
                    new ProcessBuilder("taskkill", "/IM", "notepad.exe", "/F").start();
                } else if (executable.contains("msedge")) {
                    System.out.println("edge 종료");
                    new ProcessBuilder( "taskkill", "/IM", "msedge.exe", "/F").start();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                process.destroy();
            }
        }
    }

    public String getIcon() {
        return icon;
    }
}
