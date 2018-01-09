package creativei.dao;

import creativei.entity.InquiryGuardian;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface InquiryGuardianDao extends JpaRepository<InquiryGuardian, Long> {
}
