package creativei.dao;

import creativei.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by Aayush on 12/15/2017.
 */
@Transactional
public interface BranchDao extends JpaRepository<Branch, Long>{

}
