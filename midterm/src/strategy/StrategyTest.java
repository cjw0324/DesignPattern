package strategy;

public class StrategyTest {
    public StrategyTest() {

        // 스트레티지 패턴 테스트 시작을 알리는 출력문
        System.out.println("\n\n===== Strategy Pattern Start ======\n\n");

        // 처리할 이미지 파일 목록
        String[] imageFiles = {"image/strategy_image/cat1.jpg", "image/strategy_image/cat2.jpg"};
        // 사용할 이미지 처리 전략 배열 생성
        IProcessor[] processors =  new IProcessor[]{new ImageGrayscale(), new ImageBlur(), new ImageNegative(), new ImageEdgeDetect(), new ImageRotate()};
        ImageProcessor processor;

        // 각 이미지 파일에 대해
        for (String imageFile : imageFiles) {
            // 각 이미지 처리 전략을 적용
            for (IProcessor iProcessor : processors) {
                processor = new ImageProcessor(iProcessor);  // 새로운 처리 전략으로 ImageProcessor 생성
                processor.process(imageFile);  // 이미지 파일에 대해 처리 수행
            }
        }

        // 스트레티지 패턴 테스트 종료를 알리는 출력문
        System.out.println("\n\n===== Strategy Pattern End ======\n\n");
    }
}
