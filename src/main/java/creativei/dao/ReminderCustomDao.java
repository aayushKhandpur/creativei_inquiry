package creativei.dao;


import creativei.entity.Reminder;

import java.util.Date;
import java.util.List;

public interface ReminderCustomDao {
    Reminder save(Reminder reminder);
    List<Reminder> findReminderByDateRange(Date fromDate, Date toDate);
}
