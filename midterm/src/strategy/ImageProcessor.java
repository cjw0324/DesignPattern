package strategy;

import template.ImageUtil;

import java.awt.image.BufferedImage;

// ImageProcessor 클래스는 다양한 이미지 처리 전략을 캡슐화하고 적용하는 데 사용됩니다.
public class ImageProcessor {
    private IProcessor processor;  // 이미지 처리 전략을 나타내는 IProcessor 인터페이스 참조

    // 생성자를 통해 특정 이미지 처리 전략을 초기화
    public ImageProcessor(IProcessor processor) {
        this.processor = processor;
    }

    // 현재 설정된 이미지 처리 전략을 변경
    public void setProcessor(IProcessor processor) {
        this.processor = processor;
    }

    // 주어진 파일명에 대한 이미지 처리를 수행
    public void process(String filename) {
        BufferedImage image = ImageUtil.load(filename);  // 이미지 로드
        BufferedImage outputImage = processor.process(image);  // 설정된 전략을 사용하여 이미지 처리
        String format = ImageUtil.getExtension(filename);  // 파일 확장자 추출
        String outputFile = ImageUtil.getFullpathWithoutExt(filename) + processor.toString() + "." + format;  // 출력 파일명 생성
        ImageUtil.save(outputImage, format, outputFile);  // 처리된 이미지 저장
    }
}
