package creativei.dao;

import creativei.entity.FollowUp;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface FollowUpDao extends JpaRepository<FollowUp,Long>{
}
