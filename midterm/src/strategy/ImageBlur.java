package strategy;

import java.awt.image.BufferedImage;

// ImageBlur 클래스는 IProcessor 인터페이스를 구현하여 이미지에 블러 처리를 적용하는 전략을 제공합니다.
public class ImageBlur implements IProcessor {

    // IProcessor 인터페이스의 process 메서드 구현
    @Override
    public BufferedImage process(BufferedImage image) {
        // 입력된 이미지에 블러 처리를 수행
        return blur(image);
    }

    // 실제로 이미지에 블러 효과를 적용하는 정적 메서드
    public static BufferedImage blur(BufferedImage image) {
        // template 패키지의 ImageBlur 클래스를 사용하여 이미지에 블러 처리 적용
        return template.ImageBlur.blur(image);
    }

    // 객체를 문자열로 표현할 때 사용되는 메서드
    @Override
    public String toString() {
        return "ImageBlur";  // 클래스 이름 반환
    }
}
