//Lab03, 자바프로그래밍2, 1분반, 2024-10-01, 최재우
package health.observer;

import template.DailyHealthData;

public interface Observer {
    void update(DailyHealthData d);
}
