// Lab07 자바프로그래밍2 1분반 32194692 최재우 24.11.19
// ProgramLauncherCommand 클래스는 실행 가능한 명령과 해당 아이콘 정보를 저장하는 데이터 클래스입니다.
package importer;

public class ProgramLauncherCommand {
    // 명령 실행 파일 경로
    private final String executable;
    // 명령과 연결된 아이콘 파일 경로
    private final String icon;

    /**
     * ProgramLauncherCommand 생성자.
     * 실행 파일 경로와 아이콘 경로를 초기화합니다.
     *
     * @param executable 실행 파일 경로
     * @param icon 아이콘 파일 경로
     */
    public ProgramLauncherCommand(String executable, String icon) {
        this.executable = executable;
        this.icon = icon;
    }

    /**
     * 실행 파일 경로를 반환합니다.
     *
     * @return 실행 파일 경로
     */
    public String getExecutable() {
        return executable;
    }

    /**
     * 아이콘 파일 경로를 반환합니다.
     *
     * @return 아이콘 파일 경로
     */
    public String getIcon() {
        return icon;
    }
}
