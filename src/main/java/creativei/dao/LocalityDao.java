package creativei.dao;


import creativei.entity.Locality;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface LocalityDao extends JpaRepository<Locality, Long>{
}
