package dolls;
import java.awt.*;

import decorators.Doll;

public class RabbitDoll extends Doll {

    public RabbitDoll() {
        // 토끼 이미지 로드
        image = Toolkit.getDefaultToolkit().getImage("image/rabbit.png");
    }

    @Override
    public String describe() {
        return "Rabbit Doll";  // RabbitDoll의 설명 반환
    }
}

