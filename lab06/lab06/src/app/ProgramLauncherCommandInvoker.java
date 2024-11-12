package app;

import programlaunchercommand.IProgramLauncherCommand;

import java.util.Stack;

public class ProgramLauncherCommandInvoker {
    private IProgramLauncherCommand currentCommand;
    private Stack<IProgramLauncherCommand> commandStack = new Stack<>();

    public void setCommand(IProgramLauncherCommand command) {
        this.currentCommand = command;
    }

    public void executeCommand() {
        if (currentCommand != null) {
            currentCommand.execute();
            commandStack.push(currentCommand);
        }
    }

    public void undoLastCommand() {
        if (!commandStack.isEmpty()) {
            System.out.println("undo 실행");
            IProgramLauncherCommand lastCommand = commandStack.pop();
            lastCommand.undo();
        }
    }
}
