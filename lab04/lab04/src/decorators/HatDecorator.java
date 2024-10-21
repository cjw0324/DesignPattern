//Lab04, 자바프로그래밍2, 1분반, 2024-10-08, 최재우
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
        x = rand.nextInt(30) + 100;  // x 좌표는 100 ~ 130 사이 무작위 값
        y = rand.nextInt(30) - 30;   // y 좌표는 -30 ~ 0 사이 무작위 값
        width = rand.nextInt(300) + 500;  // 무작위 크기 (500 ~ 800 사이)
        height = rand.nextInt(100) + 400;  // 무작위 크기 (400 ~ 500 사이)
    }

    @Override
    public String describe() {
        // 기존 인형의 설명에 모자 장식을 추가한 설명 반환
        return decoratedDoll.describe() + ", with a Hat";
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // 원래 인형의 이미지를 먼저 그림
        Graphics2D g2 = (Graphics2D) g;

        // 이미지가 있으면 무작위로 설정된 위치와 크기로 모자 이미지를 그림
        if (image != null) {
            g2.drawImage(image, x, y, width, height, this);
        }
    }
}
