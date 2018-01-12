package creativei.dao;

import creativei.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface InquiryDao extends JpaRepository<Inquiry,Long>{
}
