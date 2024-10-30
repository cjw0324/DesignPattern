package strategy;

import java.awt.image.BufferedImage;

// ImageRotate 클래스는 IProcessor 인터페이스를 구현하여 이미지를 지정된 각도로 회전하는 전략을 제공합니다.
public class ImageRotate implements IProcessor {

    private double angle = 45.0; // 회전할 각도를 45도로 초기 설정

    // IProcessor 인터페이스의 process 메서드 구현
    @Override
    public BufferedImage process(BufferedImage image) {
        // 입력된 이미지를 지정된 각도로 회전
        return rotate(image, angle);
    }

    // 실제로 이미지를 지정된 각도로 회전시키는 정적 메서드
    public static BufferedImage rotate(BufferedImage image, double angle) {
        // template 패키지의 ImageRotate 클래스를 사용하여 이미지 회전 처리 적용
        return template.ImageRotate.rotate(image, angle);
    }

    // 객체를 문자열로 표현할 때 사용되는 메서드
    @Override
    public String toString() {
        return "Rotate" + angle;  // "Rotate" 문자와 회전 각도를 결합한 문자열 반환
    }
}
