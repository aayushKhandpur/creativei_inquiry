package creativei.dao;

import creativei.entity.InquiryEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface InquiryEducationDao extends JpaRepository<InquiryEducation,Long> {

}

