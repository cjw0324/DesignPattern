package factorybuilder;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

// ImageEdgeDetect 클래스는 이미지에서 가장자리 감지를 처리합니다.
public class ImageEdgeDetect implements IProcessor {

	// 기본 생성자
	public ImageEdgeDetect() {
		// 생성자 호출 시 객체 정보를 출력하도록 할 수 있으나, 현재는 주석 처리되어 있음
		// System.out.println(this);
	}

	// 객체의 문자열 표현을 반환하는 메소드
	@Override
	public String toString() {
		return "ImageEdgeDetect";  // 이 클래스의 인스턴스를 문자열로 표현할 때 "ImageEdgeDetect" 반환
	}

	// IProcessor 인터페이스의 process 메소드 구현
	@Override
	public BufferedImage process(BufferedImage image) {
		// 입력된 이미지에 가장자리 감지 처리를 수행하고 결과 이미지 반환
		return edgeDetect(image);
	}

	// 실제로 이미지에 가장자리 감지 효과를 적용하는 정적 메소드
	public static BufferedImage edgeDetect(BufferedImage image)	{
		// template 패키지의 ImageEdgeDetect 클래스를 사용하여 이미지에 가장자리 감지 처리 적용
		return template.ImageEdgeDetect.edgeDetect(image);
	}
}
