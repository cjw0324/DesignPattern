//Lab01, 자바프로그래밍2, 1분반, 2024-09-14, 최재우
package Interface;

import java.time.LocalDate;

public interface PublishDateGenerator {
    LocalDate generatePublishDate(); //Local time 으로 당일의 신문만 발행됨.(임의로 설정한 조건)
}
