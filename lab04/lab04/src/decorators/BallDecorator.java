package decorators;

import java.awt.*;

public class BallDecorator extends DollDecorator {

    public BallDecorator(Doll decoratedDoll) {
        super(decoratedDoll);
        image = Toolkit.getDefaultToolkit().getImage("image/ball.png");  // 공 이미지 설정
    }

    @Override
    public String describe() {
        return decoratedDoll.describe() + ", with a Ball";  // 기존 설명에 공 추가
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // 원래 인형의 이미지를 먼저 그림
        Graphics2D g2 = (Graphics2D) g;
        if (image != null) {
            g2.drawImage(image, 100+random(), 600+random(), this);  // 공 이미지를 고양이 발 밑에 추가
        }
    }
}