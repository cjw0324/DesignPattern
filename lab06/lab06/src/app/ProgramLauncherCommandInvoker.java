//자바 프로그래밍2 1분반 32148682 최재우 24.11.12
package app;

import programlaunchercommand.IProgramLauncherCommand;

import java.util.Stack;

public class ProgramLauncherCommandInvoker {
    // 현재 실행할 명령 객체를 저장
    private IProgramLauncherCommand currentCommand;
    // 실행된 명령을 저장하는 스택, 실행된 명령을 추적하여 나중에 취소할 수 있도록 함
    private Stack<IProgramLauncherCommand> commandStack = new Stack<>();

    // 실행할 명령을 설정하는 메서드
    public void setCommand(IProgramLauncherCommand command) {
        this.currentCommand = command;
    }

    // 설정된 명령을 실행하고 스택에 저장하는 메서드
    public void executeCommand() {
        if (currentCommand != null) {
            currentCommand.execute(); // 명령 실행
            commandStack.push(currentCommand); // 실행된 명령을 스택에 저장
        }
    }

    // 마지막으로 실행된 명령을 취소하는 메서드
    public void undoLastCommand() {
        if (!commandStack.isEmpty()) {
            System.out.println("undo 실행"); // undo 작업을 알리는 출력
            IProgramLauncherCommand lastCommand = commandStack.pop(); // 스택에서 마지막 명령 가져옴
            lastCommand.undo(); // 마지막 명령 취소
        }
    }
}
