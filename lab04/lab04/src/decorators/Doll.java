package decorators;

import interfaces.IDoll;

import javax.swing.*;
import java.awt.*;

public abstract class Doll extends JPanel implements IDoll {
    protected Image image;  // 인형의 이미지를 저장할 변수

    @Override
    public abstract String describe();  // 각 서브클래스에서 구현

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (image != null) {
            g2.drawImage(image, 100, 100, this);  // 이미지가 설정되어 있으면 그리기
        }
    }
}
