//자바 프로그래밍2 1분반 32148682 최재우 24.11.12
package programlaunchercommand;

// Command 패턴의 인터페이스로, 모든 명령 클래스가 구현해야 하는 공통 메서드를 정의
public interface IProgramLauncherCommand {
    // 명령을 실행하는 메서드
    void execute();

    // 명령을 취소(되돌리기)하는 메서드
    void undo();
}
