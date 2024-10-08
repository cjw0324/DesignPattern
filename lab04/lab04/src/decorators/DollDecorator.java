package decorators;

import java.awt.*;

public abstract class DollDecorator extends Doll {
    protected Doll decoratedDoll;  // 데코레이터가 장식할 Doll 객체

    public DollDecorator(Doll decoratedDoll) {
        this.decoratedDoll = decoratedDoll;
    }

    @Override
    public String describe() {
        return decoratedDoll.describe();  // 장식할 객체의 설명을 그대로 반환
    }

    @Override
    public void paintComponent(Graphics g) {
        decoratedDoll.paintComponent(g);  // 장식할 객체의 paintComponent 메서드 호출
    }

    public static int random() {
        int random = (int) (Math.random() * 100 + 1);
        return random;
    }
}