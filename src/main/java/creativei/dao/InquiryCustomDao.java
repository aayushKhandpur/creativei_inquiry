package creativei.dao;

import creativei.entity.City;
import creativei.entity.Inquiry;
import creativei.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InquiryCustomDao extends JpaRepository<Inquiry,Long>{
    List<Inquiry> findByInquiryStatus(InquiryStatus status);
    List<Inquiry> getFilteredInquiries(InquiryStatus status, CaseIndex caseIndex, Long cityId);
}
