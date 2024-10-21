//Lab04, 자바프로그래밍2, 1분반, 2024-10-08, 최재우
package decorators;

import interfaces.IDoll;

import javax.swing.*;
import java.awt.*;

public abstract class Doll extends JPanel implements IDoll {
    protected Image image;  // 인형의 이미지를 저장할 변수

    @Override
    public abstract String describe();  // 각 서브클래스에서 인형의 설명을 구현

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // 부모 클래스의 paintComponent 호출 (JPanel 내부를 그리기 위해)
        Graphics2D g2 = (Graphics2D) g;
        if (image != null) {
            g2.drawImage(image, 100, 100, this);  // 인형 이미지가 설정되어 있으면 x=100, y=100 위치에 그리기
        }
    }
}
