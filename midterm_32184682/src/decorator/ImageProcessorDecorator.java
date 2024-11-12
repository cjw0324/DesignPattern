package decorator;

import java.awt.image.BufferedImage;

public abstract class ImageProcessorDecorator extends ImageProcessor {
    // 보호된 필드로 기본 이미지 프로세서 인스턴스를 보관
    protected ImageProcessor processor;

    // 생성자에서 기본 프로세서 인스턴스를 초기화
    public ImageProcessorDecorator(ImageProcessor processor) {
        this.processor = processor;
    }

    // 기본 프로세서의 이미지를 반환
    @Override
    public BufferedImage getImage() {
        return processor.getImage();
    }

    // 기본 프로세서의 파일 확장자를 반환
    @Override
    public String getExt() {
        return processor.getExt();
    }

    // 기본 프로세서의 파일 경로를 반환
    @Override
    public String getPath() {
        return processor.getPath();
    }
}
