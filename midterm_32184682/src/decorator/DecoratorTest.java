package decorator;

public class DecoratorTest {
    public DecoratorTest() {
        // 데코레이터 패턴 테스트 시작을 알림
        System.out.println("\n\n===== Decorator Pattern Start ======\n\n");

        // 기본 이미지 객체 생성
        ImageProcessor image1 = new PlaneImage("image/decorator_image/cat1.jpg");
        // 이미지에 그레이스케일 효과 추가
        image1 = new ImageGrayscale(image1);
        // 이미지에 블러 효과 추가
        image1 = new ImageBlur(image1);
        // 이미지에 네거티브 효과 추가
        image1 = new ImageNegative(image1);
        // 이미지 처리 실행
        image1.process();

        // 새로운 기본 이미지 객체 생성
        ImageProcessor image2 = new PlaneImage("image/decorator_image/cat2.jpg");
        // 이미지에 회전 효과 추가 (회전 각도 55.0)
        image2 = new ImageRotate(image2, 55.0);
        // 이미지에 에지 감지 효과 추가
        image2 = new ImageEdgeDetect(image2);
        // 이미지 처리 실행
        image2.process();

        // 데코레이터 패턴 테스트 종료를 알림
        System.out.println("\n\n===== Decorator Pattern End ======\n\n");
    }
}
