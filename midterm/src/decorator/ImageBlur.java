package decorator;

import java.awt.image.BufferedImage;

public class ImageBlur extends ImageProcessorDecorator {
    // 생성자에서 기반 이미지 프로세서 객체를 받아 초기화
    public ImageBlur(ImageProcessor processor) {
        super(processor);
    }

    // 이 데코레이터를 통해 처리된 이미지의 이름을 반환
    @Override
    public String getName() {
        // 부모 프로세서의 이름에 "Blur"를 추가하여 새로운 이름을 생성
        return processor.getName() + "Blur";
    }

    // 이미지 처리를 수행하는 메서드
    @Override
    public BufferedImage process(BufferedImage image) {
        // 부모 프로세서를 통해 이미지를 먼저 처리
        image = processor.process(image);
        // 처리된 이미지에 블러 효과 적용
        return blur(image);
    }

    // 실제 이미지에 블러 효과를 적용하는 정적 메서드
    public static BufferedImage blur(BufferedImage image) {
        // 'template.ImageBlur.blur'를 호출하여 이미지에 블러 효과 적용
        return template.ImageBlur.blur(image);
    }
}
