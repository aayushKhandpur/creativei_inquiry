package creativei.dao;

import creativei.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public interface ReminderDao extends JpaRepository<Reminder,Long> {
    @Query("from Reminder rem where rem.reminderTime between :to and :from")
    List<Reminder> findByDateRange(@Param("to")Date to, @Param("from") Date from);
}
