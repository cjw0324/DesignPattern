package decorators;

import java.awt.*;
import java.util.Random;

public class ToyDecorator extends DollDecorator {
    // 무작위 좌표와 크기를 저장하는 인스턴스 변수
    private int x;
    private int y;
    private int width;
    private int height;

    public ToyDecorator(Doll decoratedDoll) {
        super(decoratedDoll);
        image = Toolkit.getDefaultToolkit().getImage("image/toy.png");  // 장난감 이미지 설정
        Random rand = new Random();
        x = rand.nextInt(500) + 100;
        y = rand.nextInt(100) + 400;
        width = rand.nextInt(300) + 100;  // 무작위 크기 (50 ~ 150)
        height = rand.nextInt(300) + 400;  // 무작위 크기 (50 ~ 150)
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
            g2.drawImage(image, x, y, width, height, this);  // 장난감 이미지를 고양이 옆에 추가
        }
    }
}