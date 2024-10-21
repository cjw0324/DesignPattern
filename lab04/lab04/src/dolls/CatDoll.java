//Lab04, 자바프로그래밍2, 1분반, 2024-10-08, 최재우
package dolls;

import decorators.Doll;

import java.awt.*;

public class CatDoll extends Doll {

    public CatDoll() {
        // 고양이 이미지 로드
        image = Toolkit.getDefaultToolkit().getImage("image/cat.png");  // cat.png 이미지를 설정
    }

    @Override
    public String describe() {
        // 고양이 인형의 설명을 반환
        return "Cat Doll";
    }
}
