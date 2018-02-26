package creativei.dao;

import creativei.entity.Inquiry;
import creativei.entity.Locality;
import creativei.enums.InquiryStatus;
import creativei.vo.AddressVo;
import creativei.vo.InquiryVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface InquiryDao extends JpaRepository<Inquiry,Long>,JpaSpecificationExecutor<Inquiry>{
    List<Inquiry> findByInquiryStatus(@Param("status")InquiryStatus status);
    List<Inquiry> findByInquiryStatusAndIsAttended(InquiryStatus inquiryStatus,Boolean isAttended);
}
