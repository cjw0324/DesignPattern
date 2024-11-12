package factorybuilder;

public class FactoryBuilderTest {

    public FactoryBuilderTest() {
        // 팩토리 빌더 패턴의 시작을 알리는 출력문
        System.out.println("\n\n===== Factory Builder Pattern Start ======\n\n");

        // 처리할 이미지 파일 목록
        String[] imagefiles = {"image/factory_builder_image/cat1.jpg", "image/factory_builder_image/cat2.jpg"};

        // 이미지 프로세서 빌더를 사용하여 처리 파이프라인 구성
        ImageProcessor imageProcessor = new ImageProcessor.Builder()
                // 팩토리를 사용해 각 처리 모듈의 인스턴스를 생성하고 추가
                .add(ImageProcessorFactory.createInstance("Grayscale"))
                .add(ImageProcessorFactory.createInstance("Blur"))
                .add(ImageProcessorFactory.createInstance("Negative"))
                .add(ImageProcessorFactory.createInstance("EdgeDetect"))
                // 회전 처리 모듈은 각도 인자를 받아 생성
                .add(ImageProcessorFactory.createInstance("Rotate", 50.0))
                .build();

        // 구성된 이미지 프로세서를 사용하여 각 이미지 파일에 대해 처리 수행
        for (String filename : imagefiles) {
            imageProcessor.process(filename);
        }

        // 팩토리 빌더 패턴의 종료를 알리는 출력문
        System.out.println("\n\n===== Factory Builder Pattern End ======\n\n");
    }
}
