package observer;

import strategy.IProcessor;

// ObserverTest 클래스는 옵저버 패턴을 사용하여 이미지 처리를 테스트하는 클래스입니다.
public class ObserverTest {
    public ObserverTest() {

        // 옵저버 패턴 테스트 시작을 알리는 출력문
        System.out.println("\n\n===== Observer Pattern Start ======\n\n");

        // 처리할 이미지 파일 목록
        String[] imageFiles = {"image/observer_image/cat1.jpg", "image/observer_image/cat2.jpg"};

        // ImageProcessor 객체 생성
        ImageProcessor imageProcessor = new ImageProcessor();
        // Observer 객체 배열 생성 및 초기화
        Observer[] observers = {new ImageGrayscale(), new ImageBlur(), new ImageNegative(), new ImageEdgeDetect(), new ImageRotate()};

        // 각 Observer를 ImageProcessor에 첨부
        for (Observer observer : observers) {
            imageProcessor.attachObserver(observer);
        }
        // 각 이미지 파일에 대해 설정하고 처리 요청
        for (String imageFile : imageFiles) {
            imageProcessor.setImage(imageFile);
        }

        // 옵저버 패턴 테스트 종료를 알리는 출력문
        System.out.println("\n\n===== Observer Pattern End ======\n\n");
    }
}
