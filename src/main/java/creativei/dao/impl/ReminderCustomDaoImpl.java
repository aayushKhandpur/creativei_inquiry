package creativei.dao.impl;

import creativei.dao.ReminderCustomDao;
import creativei.dao.ReminderDao;
import creativei.dao.specification.ReminderSpecification;
import creativei.entity.Reminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
    public List<Reminder> findReminderByDateRange(Date fromDate, Date toDate) {
        Specification<Reminder> specification=ReminderSpecification.reminderBetweenDateRange(fromDate,toDate);
        return reminderDao.findAll(specification);
    }
}
