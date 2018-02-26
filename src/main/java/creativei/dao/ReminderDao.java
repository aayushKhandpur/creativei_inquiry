package creativei.dao;

import creativei.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface ReminderDao extends JpaRepository<Reminder,Long> {
}
