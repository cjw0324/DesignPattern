package factorybuilder;

import java.awt.image.BufferedImage;

// 이미지 처리를 위한 인터페이스 IProcessor
public interface IProcessor {
    // 이미지 처리를 수행하고, 처리된 이미지를 BufferedImage 형태로 반환하는 메소드
    BufferedImage process(BufferedImage image);
}
