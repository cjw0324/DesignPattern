package factorybuilder;

import java.awt.Color;
import java.awt.image.BufferedImage;

// ImageGrayscale 클래스는 이미지를 그레이스케일로 처리하는 기능을 구현합니다.
public class ImageGrayscale implements IProcessor{

	// 기본 생성자
	public ImageGrayscale(){
		// 생성자 호출 시 객체 정보를 출력하도록 할 수 있으나, 현재는 주석 처리되어 있음
		// System.out.println(this);
	}

	// IProcessor 인터페이스의 process 메소드 구현
	@Override
	public BufferedImage process(BufferedImage image) {
		// 입력된 이미지에 그레이스케일 처리를 수행하고 결과 이미지 반환
		return grayscale(image);
	}

	// 객체의 문자열 표현을 반환하는 메소드
	@Override
	public String toString(){
		return "ImageGrayscale";  // 이 클래스의 인스턴스를 문자열로 표현할 때 "ImageGrayscale" 반환
	}

	// 실제로 이미지에 그레이스케일 효과를 적용하는 정적 메소드
	public static BufferedImage grayscale(BufferedImage image)	{
		// template 패키지의 ImageGrayscale 클래스를 사용하여 이미지에 그레이스케일 처리 적용
		return template.ImageGrayscale.grayscale(image);
	}
}
