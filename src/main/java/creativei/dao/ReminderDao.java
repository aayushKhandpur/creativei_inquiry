package creativei.dao;

import creativei.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public interface ReminderDao extends JpaRepository<Reminder,Long> ,JpaSpecificationExecutor<Reminder>{
}
