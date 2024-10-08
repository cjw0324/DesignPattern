//Lab04, 자바프로그래밍2, 1분반, 2024-10-08, 최재우
package decorators;

import java.awt.*;
import java.util.Random;

public class BallDecorator extends DollDecorator {

    // 무작위 좌표와 크기를 저장하는 인스턴스 변수
    private int x;
    private int y;
    private int width;
    private int height;

    public BallDecorator(Doll decoratedDoll) {
        super(decoratedDoll);  // 부모 클래스의 생성자를 호출하여 장식할 인형을 설정
        image = Toolkit.getDefaultToolkit().getImage("image/ball.png");  // 공 이미지 설정

        Random rand = new Random();

        // x, y 좌표는 100~600, 700~800 사이의 무작위 값으로 설정
        x = rand.nextInt(500) + 100;
        y = rand.nextInt(100) + 700;

        // 크기는 각각 100~700, 100~500 사이의 무작위 값으로 설정
        width = rand.nextInt(600) + 100;  // 무작위 크기 (100 ~ 700)
        height = rand.nextInt(400) + 100;  // 무작위 크기 (100 ~ 500)

    }

    @Override
    public String describe() {
        // 기존 인형의 설명에 공이 추가된 설명 반환
        return decoratedDoll.describe() + ", with a Ball";
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // 원래 인형의 이미지를 먼저 그림
        Graphics2D g2 = (Graphics2D) g;

        // 무작위로 설정된 위치와 크기로 공 이미지를 그림
        if (image != null) {
            g2.drawImage(image, x, y, width, height, this);
        }
    }
}
