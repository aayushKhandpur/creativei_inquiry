package creativei.dao;

import creativei.entity.InquiryMarketing;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface InquiryMarketingDao extends JpaRepository<InquiryMarketing,Long> {
}
