package creativei.manager;

import creativei.entity.Reminder;
import creativei.vo.ReminderVo;
import creativei.vo.ResponseObject;

import java.util.Date;

public interface ReminderManager {
    ResponseObject create(ReminderVo reminderVo);
    ResponseObject getReminderByDateRange(String to,String from);
}
