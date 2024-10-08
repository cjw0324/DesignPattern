package dolls;

import decorators.Doll;

import java.awt.*;

public class CatDoll extends Doll {

    public CatDoll() {
        // 고양이 이미지 로드
        image = Toolkit.getDefaultToolkit().getImage("image/cat.png");
    }

    @Override
    public String describe() {
        return "Cat Doll";  // CatDoll의 설명 반환
    }
}