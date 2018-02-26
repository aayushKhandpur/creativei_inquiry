package creativei.manager;

import creativei.entity.Reminder;
import creativei.vo.ReminderVo;
import creativei.vo.ResponseObject;

public interface ReminderManager {
    ResponseObject create(ReminderVo reminderVo);
}
