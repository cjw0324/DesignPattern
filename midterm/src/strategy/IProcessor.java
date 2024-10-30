package strategy;

import java.awt.image.BufferedImage;

// IProcessor 인터페이스는 스트레티지 패턴에서 이미지 처리를 위한 전략의 공통 인터페이스를 정의합니다.
public interface IProcessor {
    // 이미지를 처리하고, 처리된 이미지를 BufferedImage 형태로 반환하는 메서드
    BufferedImage process(BufferedImage image);
}
