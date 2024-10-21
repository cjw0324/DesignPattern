//Lab04, 자바프로그래밍2, 1분반, 2024-10-08, 최재우
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

        // 무작위 위치와 크기를 결정
        Random rand = new Random();
        x = rand.nextInt(500) + 100;  // x 좌표는 100 ~ 600 사이의 무작위 값
        y = rand.nextInt(100) + 400;  // y 좌표는 400 ~ 500 사이의 무작위 값
        width = rand.nextInt(300) + 100;  // 폭: 100 ~ 400 사이 무작위 값
        height = rand.nextInt(300) + 400;  // 높이: 400 ~ 700 사이 무작위 값
    }

    @Override
    public String describe() {
        // 기존 인형 설명에 장난감 추가
        return decoratedDoll.describe() + ", with a Toy";
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // 원래 인형의 이미지를 먼저 그림
        Graphics2D g2 = (Graphics2D) g;

        // 무작위로 설정된 위치와 크기로 장난감 이미지를 그림
        if (image != null) {
            g2.drawImage(image, x, y, width, height, this);  // 장난감 이미지를 x, y 좌표에 그리기
        }
    }
}
