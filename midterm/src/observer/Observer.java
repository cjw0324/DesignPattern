package observer;

import java.awt.image.BufferedImage;

// Observer 인터페이스는 이미지 처리 시스템에서 상태 변화에 반응하는 객체들이 구현해야 하는 인터페이스입니다.
public interface Observer {
    // 이미지를 처리하는 메소드
    BufferedImage process(BufferedImage image);
}
