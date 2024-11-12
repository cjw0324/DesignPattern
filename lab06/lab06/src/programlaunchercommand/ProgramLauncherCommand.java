package programlaunchercommand;

public class ProgramLauncherCommand implements IProgramLauncherCommand {

    private String executable;
    private String icon;
    private Process process;

    public String getExecutable() {
        return executable;
    }

    public ProgramLauncherCommand setExecutable(String executable) {
        this.executable = executable;
        return this;
    }

    public String getIcon() {
        return icon;
    }

    public ProgramLauncherCommand setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public Process getProcess() {
        return process;
    }

    public ProgramLauncherCommand setProcess(Process process) {
        this.process = process;
        return this;
    }

    public ProgramLauncherCommand(String executable, String icon) {
        this.executable = executable;
        this.icon = icon;
    }


    @Override
    public void execute() {
        // 실행
        try {
            ProcessBuilder pb = new ProcessBuilder(executable.split(""));
            process = pb.start();
        } catch (Exception e) {

        }

    }

    @Override
    public void undo() {
        //되돌아가기
    }
}
