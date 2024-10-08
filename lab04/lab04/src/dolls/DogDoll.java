package dolls;

import decorators.Doll;

import java.awt.*;

public class DogDoll extends Doll {

    public DogDoll() {
        // 개 이미지 로드
        image = Toolkit.getDefaultToolkit().getImage("image/dog.png");
    }

    @Override
    public String describe() {
        return "Dog Doll";  // DogDoll의 설명 반환
    }
}