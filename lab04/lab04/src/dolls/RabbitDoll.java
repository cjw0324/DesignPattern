//Lab04, 자바프로그래밍2, 1분반, 2024-10-08, 최재우
package dolls;

import java.awt.*;
import decorators.Doll;

public class RabbitDoll extends Doll {

    public RabbitDoll() {
        // 토끼 이미지 로드
        image = Toolkit.getDefaultToolkit().getImage("image/rabbit.png");  // rabbit.png 이미지를 설정
    }

    @Override
    public String describe() {
        // 토끼 인형의 설명을 반환
        return "Rabbit Doll";
    }
}
