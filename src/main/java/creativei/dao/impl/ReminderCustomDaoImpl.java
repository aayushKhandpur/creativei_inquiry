package creativei.dao.impl;

import creativei.dao.ReminderCustomDao;
import creativei.dao.ReminderDao;
import creativei.entity.Reminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class ReminderCustomDaoImpl implements ReminderCustomDao {

    @Autowired
    ReminderDao reminderDao;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Reminder save(Reminder reminder) {
        return reminderDao.save(reminder);
    }

    @Override
    public List<Reminder> findRemindersBetweenDates(Date toDate, Date fromDate) {
        return reminderDao.findByDateRange(toDate,fromDate);
    }

    @Override
    public List<Reminder> findReminderLesserThanDate(Date toDate) {
        return reminderDao.findByToDate(toDate);
    }

    @Override
    public List<Reminder> findReminderGreaterThanDate(Date fromDate) {
        return reminderDao.findByFromDate(fromDate);
    }
}
