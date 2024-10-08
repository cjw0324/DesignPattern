package decorators;

import java.awt.*;

public class ToyDecorator extends DollDecorator {

    public ToyDecorator(Doll decoratedDoll) {
        super(decoratedDoll);
        image = Toolkit.getDefaultToolkit().getImage("image/toy.png");  // 장난감 이미지 설정
    }

    @Override
    public String describe() {
        return decoratedDoll.describe() + ", with a Toy";  // 기존 설명에 장난감 추가
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // 원래 인형의 이미지를 먼저 그림
        Graphics2D g2 = (Graphics2D) g;
        if (image != null) {
            g2.drawImage(image, 200+random(), 350+random(), this);  // 장난감 이미지를 고양이 옆에 추가
        }
    }
}