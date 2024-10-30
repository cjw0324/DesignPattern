package decorator;

import template.ImageUtil;

import java.awt.image.BufferedImage;
import java.util.UUID;

public abstract class ImageProcessor {
    // 이미지, 이름, 확장자, 경로를 저장하는 보호된 필드
    protected BufferedImage image = null;
    protected String name = null;
    protected String ext = null;
    protected String path = null;

    // 파일명을 받아 이미지를 로드하고, 파일의 메타데이터(이름, 확장자, 경로)를 설정하는 메소드
    public void load(String filename) {
        image = ImageUtil.load(filename);  // 이미지를 로드
        name = ImageUtil.getFilenameWithoutExt(filename);  // 확장자를 제외한 파일 이름을 추출
        ext = ImageUtil.getExtension(filename);  // 파일의 확장자를 추출
        path = ImageUtil.getPath(filename);  // 파일의 경로를 추출
    }

    // 이미지를 처리하고 결과를 파일로 저장하는 메소드
    public void process() {
        BufferedImage newImage = process(getImage());  // 추상 메소드를 사용하여 이미지를 처리
        String outputFile = (getPath() != null ? getPath() + "/" : "") + getName() + "." + getExt();  // 출력 파일 경로 생성
        if (newImage != null) {
            ImageUtil.save(newImage, getExt(), outputFile);  // 처리된 이미지를 파일로 저장
        } else {
            System.out.println("image load fail");  // 이미지 처리 실패 시 오류 메시지 출력
        }
    }

    // 이미지를 반환하는 getter 메소드
    public BufferedImage getImage() {
        return image;
    }

    // 이름을 반환하는 추상 메소드, 데코레이터에서 구현 필요
    public abstract String getName();

    // 이미지 처리 로직을 구현할 추상 메소드, 데코레이터에서 구현 필요
    public abstract BufferedImage process(BufferedImage image);

    // 파일 확장자를 반환하는 getter 메소드
    public String getExt() {
        return ext;
    }

    // 파일 경로를 반환하는 getter 메소드
    public String getPath() {
        return path;
    }
}
