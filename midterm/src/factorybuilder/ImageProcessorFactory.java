package factorybuilder;

// 이미지 처리 객체를 생성하는 팩토리 클래스
public class ImageProcessorFactory {

    // 이미지 처리 유형에 따라 적절한 IProcessor 인스턴스를 생성하고 반환하는 정적 메서드
    public static IProcessor createInstance(String type, double... params) {
        // 그레이스케일 처리 객체 생성
        if (type.equals("Grayscale")) {
            return new ImageGrayscale();
            // 블러 처리 객체 생성
        } else if (type.equals("Blur")) {
            return new ImageBlur();
            // 네거티브 처리 객체 생성
        } else if (type.equals("Negative")) {
            return new ImageNegative();
            // 가장자리 감지 처리 객체 생성
        } else if (type.equals("EdgeDetect")) {
            return new ImageEdgeDetect();
            // 회전 처리 객체 생성, 회전 각도는 params 매개변수에서 받음
        } else if (type.equals("Rotate")) {
            return new ImageRotate(params[0]);
            // 지원하지 않는 유형일 경우 예외 발생
        } else {
            throw new IllegalArgumentException("Unknown processor type");
        }
    }
}
