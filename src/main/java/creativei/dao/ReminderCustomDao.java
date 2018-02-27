package creativei.dao;


import creativei.entity.Reminder;

import java.util.Date;
import java.util.List;

public interface ReminderCustomDao {
    Reminder save(Reminder reminder);
    List<Reminder> findRemindersBetweenDates(Date toDate, Date fromDate);
    List<Reminder> findReminderLesserThanDate(Date toDate);
    List<Reminder> findReminderGreaterThanDate(Date fromDate);
}
