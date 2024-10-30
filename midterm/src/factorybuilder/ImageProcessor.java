package factorybuilder;

import template.ImageUtil;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

// 이미지 처리 작업을 체인 방식으로 관리하고 실행하는 ImageProcessor 클래스
public class ImageProcessor {
    private List<IProcessor> processors = new ArrayList<>();

    // 객체 생성을 빌더 패턴을 통해서만 허용하기 위한 private 생성자
    private ImageProcessor(Builder builder) {
        this.processors = builder.processors; // 빌더로부터 프로세서 목록을 초기화
    }

    // 처리기 목록을 반환하는 getter 메소드
    public List<IProcessor> getProcessors() {
        return processors;
    }

    // 지정된 이미지 파일을 모든 추가된 처리기를 통해 처리
    public void process(String filename) {
        for (IProcessor p : processors) {
            BufferedImage image = ImageUtil.load(filename); // 각 처리기에 대해 원본 이미지를 로드
            BufferedImage outputImage = p.process(image); // 현재 처리기의 효과를 적용
            String format = ImageUtil.getExtension(filename); // 파일 형식 추출
            // 처리기 이름을 포함한 출력 파일명 구성
            String outputFile = ImageUtil.getFullpathWithoutExt(filename) + p.toString() + "." + format;
            ImageUtil.save(outputImage, format, outputFile); // 처리된 이미지 저장
        }
    }

    // ImageProcessor 인스턴스를 구성하기 위한 static 내부 Builder 클래스
    public static class Builder {
        private List<IProcessor> processors = new ArrayList<>();

        // 빌더에 처리기를 추가하는 메소드
        public Builder add(IProcessor processor) {
            processors.add(processor); // 처리기 목록에 새로운 처리기 추가
            return this; // 메소드 체이닝을 허용하기 위해 빌더 자신을 반환
        }

        // 빌더의 현재 상태를 사용하여 ImageProcessor 인스턴스 생성
        public ImageProcessor build() {
            return new ImageProcessor(this); // 현재 빌더 상태로 새 인스턴스 생성
        }

    }

}
