package health.observer;

import template.DailyHealthData;

public interface Observer {
    void update(DailyHealthData d);
}
