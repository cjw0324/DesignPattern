package factorybuilder;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

// ImageRotate 클래스는 이미지를 지정된 각도로 회전시키는 기능을 구현합니다.
public class ImageRotate implements IProcessor {

	private double angle = 45.0; // 회전할 기본 각도는 45.0도로 설정

	// 생성자에서 회전 각도를 설정
	public ImageRotate(double angle) {
		this.angle = angle; // 입력받은 각도로 회전 각도 설정
		// 객체 정보를 출력할 수 있으나, 현재는 주석 처리됨
		// System.out.println(this);
	}

	// 객체를 문자열로 표현할 때 사용되는 메서드
	@Override
	public String toString() {
		return "ImageRotate" + this.angle; // 클래스 이름과 회전 각도를 포함한 문자열 반환
	}

	// IProcessor 인터페이스의 process 메서드 구현
	@Override
	public BufferedImage process(BufferedImage image) {
		// 입력된 이미지에 회전 처리를 수행하고 결과 이미지 반환
		return rotate(image, angle);
	}

	// 실제로 이미지에 회전 효과를 적용하는 정적 메소드
	public static BufferedImage rotate(BufferedImage image, double rotateAngle) {
		// template 패키지의 ImageRotate 클래스를 사용하여 이미지에 회전 처리 적용
		return template.ImageRotate.rotate(image, rotateAngle);
	}
}
