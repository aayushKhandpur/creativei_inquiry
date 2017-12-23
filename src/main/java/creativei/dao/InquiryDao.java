package creativei.dao;

import creativei.entity.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 12/16/2017.
 */
public interface InquiryDao extends JpaRepository<Inquiry,Long>{
}
