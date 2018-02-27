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
    @Query("from Reminder rem where rem.reminderTime between :toDate and :fromDate")
    List<Reminder> findByDateRange(@Param("toDate")Date toDate, @Param("fromDate") Date fromDate);

    @Query("from Reminder rem where rem.reminderTime <= :toDate")
    List<Reminder> findByToDate(@Param("toDate")Date toDate);

    @Query("from Reminder rem where rem.reminderTime >= :fromDate")
    List<Reminder> findByFromDate(@Param("fromDate")Date fromDate);
}
