package creativei.dao;

import creativei.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface StateDao extends JpaRepository<State,Long> {
}
