package decorator;

import java.awt.image.BufferedImage;

public class PlaneImage extends ImageProcessor {
    // 생성자에서 파일명을 받아 이미지를 로드
    public PlaneImage(String filename) {
        load(filename);  // 부모 클래스의 load 메소드를 호출하여 이미지 로드
    }

    // 이미지의 이름을 반환하는 메서드
    @Override
    public String getName() {
        return name;  // 이미지 이름 반환
    }

    // 이미지 처리를 수행하는 메서드, 본 클래스에서는 추가 처리 없이 원본 이미지 반환
    @Override
    public BufferedImage process(BufferedImage image) {
        return image;  // 입력받은 이미지 객체를 그대로 반환
    }
}
