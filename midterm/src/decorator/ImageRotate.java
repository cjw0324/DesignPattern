package decorator;

import java.awt.image.BufferedImage;

public class ImageRotate extends ImageProcessorDecorator {
    // 회전할 각도를 저장하는 프라이빗 필드
    private double angle = 0.0;

    // 생성자에서 기본 프로세서와 회전 각도를 초기화
    public ImageRotate(ImageProcessor processor, double angle) {
        super(processor);  // 부모 클래스의 생성자 호출
        this.angle = angle;  // 회전 각도 설정
    }

    // 이 데코레이터를 통해 처리된 이미지의 이름을 반환
    @Override
    public String getName() {
        // 부모 프로세서의 이름에 "Rotate"와 각도를 추가하여 새로운 이름을 생성
        return processor.getName() + "Rotate" + angle;
    }

    // 이미지 처리를 수행하는 메서드
    @Override
    public BufferedImage process(BufferedImage image) {
        // 부모 프로세서를 통해 이미지를 먼저 처리
        image = processor.process(image);
        // 처리된 이미지에 회전 효과 적용
        return rotate(image, angle);
    }

    // 실제 이미지에 회전 효과를 적용하는 정적 메서드
    public static BufferedImage rotate(BufferedImage image, double angle) {
        // 'template.ImageRotate.rotate'를 호출하여 이미지에 회전 효과 적용
        return template.ImageRotate.rotate(image, angle);
    }
}
