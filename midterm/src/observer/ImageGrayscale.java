package observer;

import java.awt.image.BufferedImage;

// ImageGrayscale 클래스는 Observer 인터페이스를 구현하여 이미지를 그레이스케일로 처리하는 기능을 제공합니다.
public class ImageGrayscale implements Observer {

    // Observer 인터페이스의 process 메서드 구현
    @Override
    public BufferedImage process(BufferedImage image) {
        // 입력된 이미지에 그레이스케일 처리를 수행
        return grayscale(image);
    }

    // 실제 이미지에 그레이스케일 효과를 적용하는 정적 메서드
    public static BufferedImage grayscale(BufferedImage image) {
        // template 패키지의 ImageGrayscale 클래스를 사용하여 이미지에 그레이스케일 처리 적용
        return template.ImageGrayscale.grayscale(image);
    }

    // 객체를 문자열로 표현할 때 사용되는 메서드
    @Override
    public String toString() {
        return "ImageGrayScale";  // 클래스 이름 반환
    }
}
