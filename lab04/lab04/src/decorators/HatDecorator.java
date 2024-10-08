package decorators;

import java.awt.*;

public class HatDecorator extends DollDecorator {

    public HatDecorator(Doll decoratedDoll) {
        super(decoratedDoll);
        image = Toolkit.getDefaultToolkit().getImage("image/hat.png");  // 모자 이미지 설정
    }

    @Override
    public String describe() {
        return decoratedDoll.describe() + ", with a Hat";  // 기존 설명에 모자 추가
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // 원래 인형의 이미지를 먼저 그림
        Graphics2D g2 = (Graphics2D) g;
        if (image != null) {
            int rand = random();
            g2.drawImage(image, -20 + rand, -150 + rand, this);// 모자 이미지를 고양이 머리 위에 추가
            rand = 0;
        }
    }
}