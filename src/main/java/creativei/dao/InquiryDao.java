package creativei.dao;

import creativei.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

/**
 * Created by user on 12/16/2017.
 */
@Transactional
public interface InquiryDao extends JpaRepository<Inquiry,Long>{
}
