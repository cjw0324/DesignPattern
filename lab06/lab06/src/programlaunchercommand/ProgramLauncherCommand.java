//자바 프로그래밍2 1분반 32148682 최재우 24.11.12
package programlaunchercommand;

import java.io.IOException;

public class ProgramLauncherCommand implements IProgramLauncherCommand {

    // 실행 파일 경로와 아이콘 경로를 저장
    private String executable;
    private String icon;
    private Process process; // 실행 중인 프로세스를 추적하기 위한 변수

    // 실행 파일 경로와 아이콘을 초기화하는 생성자
    public ProgramLauncherCommand(String executable, String icon) {
        this.executable = executable;
        this.icon = icon;
    }

    @Override
    public void execute() {
        // 명령을 실행하는 메서드
        try {
            ProcessBuilder pb;
            if (executable.split(" ").length > 1) {
                // 명령어가 여러 단어로 구성된 경우 공백으로 분리하여 ProcessBuilder에 전달
                pb = new ProcessBuilder(executable.split(" "));
            } else {
                // 단일 명령어인 경우 단일 경로로 ProcessBuilder 생성
                pb = new ProcessBuilder(executable);
            }
            process = pb.start(); // 프로세스 시작
        } catch (IOException e) {
            throw new RuntimeException(e); // 예외 발생 시 RuntimeException으로 래핑하여 던짐
        }
    }

    @Override
    public void undo() {
        // 실행된 프로세스를 종료하는 메서드
        if (process != null) {
            try {
                System.out.println("undo start"); // undo 작업 시작 알림
                if (executable.contains("notepad")) {
                    System.out.println("notepad 종료"); // Notepad 종료 알림
                    // Windows 명령어를 통해 Notepad 강제 종료
                    new ProcessBuilder("taskkill", "/IM", "notepad.exe", "/F").start();
                } else if (executable.contains("msedge")) {
                    System.out.println("edge 종료"); // Edge 종료 알림
                    // Windows 명령어를 통해 Edge 강제 종료
                    new ProcessBuilder("taskkill", "/IM", "msedge.exe", "/F").start();
                }
            } catch (IOException e) {
                e.printStackTrace(); // 예외 발생 시 스택 추적 출력
            } finally {
                process.destroy(); // 프로세스가 여전히 살아 있다면 종료
            }
        }
    }

    // 아이콘 경로를 반환하는 메서드
    public String getIcon() {
        return icon;
    }
}
