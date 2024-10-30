package observer;

import template.ImageUtil;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

// Subject 인터페이스를 구현하는 ImageProcessor 클래스는 이미지 처리를 관리합니다.
public class ImageProcessor implements Subject {
    private BufferedImage image;
    private String filename;
    private List<Observer> observers = new ArrayList<>();

    // Observer를 추가하는 메소드
    @Override
    public void attachObserver(Observer observer) {
        observers.add(observer);
    }

    // Observer를 제거하는 메소드
    @Override
    public void detachObserver(Observer observer) {
        observers.remove(observer);
    }

    // 모든 Observer들에게 변경을 알리는 메소드
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            BufferedImage outputImage = observer.process(image); // 각 Observer에 이미지 처리 요청
            if (outputImage == null) {
                System.out.println("null"); // 처리 결과가 null인 경우 오류 메시지 출력
            }
            saveImage(outputImage, observer); // 처리된 이미지 저장
        }
    }

    // 처리된 이미지를 파일로 저장하는 메소드
    public void saveImage(BufferedImage outputImage, Observer observer) {
        String format = ImageUtil.getExtension(filename); // 파일 형식 추출
        String outputFile = ImageUtil.getFullpathWithoutExt(filename) + observer.toString() + "." + format; // 출력 파일명 구성
        ImageUtil.save(outputImage, format, outputFile); // 파일 저장
    }

    // 새로운 이미지를 설정하고 관찰자들에게 알림
    public void setImage(String filename) {
        this.filename = filename;
        this.image = ImageUtil.load(filename); // 이미지 로드
        notifyObservers(); // 모든 Observer들에게 변경을 알림
    }

}
