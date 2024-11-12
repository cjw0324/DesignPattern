package observer;

import java.awt.image.BufferedImage;

// ImageRotate 클래스는 Observer 인터페이스를 구현하여 이미지 회전 기능을 제공합니다.
public class ImageRotate implements Observer {

    private double angle = 45.0; // 기본 회전 각도를 45도로 설정

    // Observer 인터페이스의 process 메서드 구현
    @Override
    public BufferedImage process(BufferedImage image) {
        // 입력된 이미지를 지정된 각도로 회전
        return rotate(image, angle);
    }

    // 실제로 이미지를 지정된 각도로 회전시키는 메서드
    public static BufferedImage rotate(BufferedImage image, double angle) {
        // template 패키지의 ImageRotate 클래스를 사용하여 이미지 회전 처리 적용
        return template.ImageRotate.rotate(image, angle);
    }

    // 객체를 문자열로 표현할 때 사용되는 메서드
    @Override
    public String toString() {
        return "ImageRotate";  // 클래스 이름과 회전 각도를 포함한 문자열 반환
    }
}
