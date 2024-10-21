//Lab04, 자바프로그래밍2, 1분반, 2024-10-08, 최재우
package decorators;

import java.awt.*;

public abstract class DollDecorator extends Doll {
    protected Doll decoratedDoll;  // 데코레이터가 장식할 Doll 객체

    public DollDecorator(Doll decoratedDoll) {
        this.decoratedDoll = decoratedDoll;  // 장식할 인형 객체를 설정
    }

    @Override
    public String describe() {
        return decoratedDoll.describe();  // 장식된 인형의 설명을 반환 (추가 장식에 대한 설명은 서브클래스에서 추가)
    }

    @Override
    public void paintComponent(Graphics g) {
        // 장식할 객체의 paintComponent 메서드를 호출하여 원래 인형의 이미지가 먼저 그려지도록 함
        decoratedDoll.paintComponent(g);
    }

}
