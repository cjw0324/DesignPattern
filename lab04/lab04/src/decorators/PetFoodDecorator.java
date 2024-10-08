//Lab04, 자바프로그래밍2, 1분반, 2024-10-08, 최재우
package decorators;

import java.awt.*;
import java.util.Random;

public class PetFoodDecorator extends DollDecorator {
    // 무작위 좌표와 크기를 저장하는 인스턴스 변수
    private int x;
    private int y;
    private int width;
    private int height;
    
    public PetFoodDecorator(Doll decoratedDoll) {
        super(decoratedDoll);
        image = Toolkit.getDefaultToolkit().getImage("image/petFood.png");  // 사료 이미지 설정

        // 무작위 위치와 크기를 결정
        Random rand = new Random();
        x = rand.nextInt(30) + 10;  // x 좌표는 10 ~ 40 사이 무작위 값
        y = rand.nextInt(30) + 800;   // y 좌표는 800 ~ 830 사이 무작위 값
        width = rand.nextInt(300) + 100;  // 무작위 크기 (100 ~ 400 사이)
        height = rand.nextInt(100) + 200;  // 무작위 크기 (200 ~ 300 사이)
    }

    @Override
    public String describe() {
        // 기존 인형의 설명에 사료 장식을 추가한 설명 반환
        return decoratedDoll.describe() + ", with a pet food";
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);  // 원래 인형의 이미지를 먼저 그림
        Graphics2D g2 = (Graphics2D) g;

        // 이미지가 있으면 무작위로 설정된 위치와 크기로  이미지를 그림
        if (image != null) {
            g2.drawImage(image, x, y, width, height, this);
        }
    }

}
