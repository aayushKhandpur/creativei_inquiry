package creativei.dao.impl;

import creativei.dao.ReminderCustomDao;
import creativei.dao.ReminderDao;
import creativei.entity.Reminder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class ReminderCustomDaoImpl implements ReminderCustomDao {

    @Autowired
    ReminderDao reminderDao;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Reminder save(Reminder reminder) {
        return null;
    }
}
