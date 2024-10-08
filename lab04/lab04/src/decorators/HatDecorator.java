package decorators;

import java.awt.*;
import java.util.Random;

public class HatDecorator extends DollDecorator {

    // 무작위 좌표와 크기를 저장하는 인스턴스 변수
    private int x;
    private int y;
    private int width;
    private int height;

    public HatDecorator(Doll decoratedDoll) {
        super(decoratedDoll);
        image = Toolkit.getDefaultToolkit().getImage("image/hat.png");  // 모자 이미지 설정

        // 무작위 위치와 크기를 결정
        Random rand = new Random();
        x = rand.nextInt(30) + 100;
        y = rand.nextInt(30) - 30;
        width = rand.nextInt(300) + 500;  // 무작위 크기 (50 ~ 150)
        height = rand.nextInt(100) + 400;  // 무작위 크기 (50 ~ 150)
    }

    @Override
    public String describe() {
        return decoratedDoll.describe() + ", with a Hat";  // 기존 설명에 모자 추가
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;



        if (image != null) {
            g2.drawImage(image, x, y, width, height, this);
        }
    }
}