package creativei.dao;

import creativei.entity.Inquiry;
import creativei.entity.Locality;
import creativei.enums.CaseIndex;
import creativei.enums.FollowUpStatus;
import creativei.enums.InquiryStatus;
import creativei.vo.AddressVo;
import creativei.vo.InquiryVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Transactional
public interface InquiryDao extends JpaRepository<Inquiry, Long>, JpaSpecificationExecutor<Inquiry> {
    List<Inquiry> findByInquiryStatus(@Param("status") InquiryStatus status);

    List<Inquiry> findByInquiryStatusAndIsAttended(InquiryStatus inquiryStatus, Boolean isAttended);

    @Query("select count(inq.id) from Inquiry inq where inq.inquiryDate between :inquiryToDate And :inquiryFromDate")
    Integer findCountByInquiryDate(@Param("inquiryToDate") Date inquiryToDate, @Param("inquiryFromDate") Date inquiryFromDate);

    @Query("select count(inq.id) from Inquiry inq join inq.followUps follUp  where inq.inquiryDate between :inquiryToDate And :inquiryFromDate and follUp.caseIndex=:caseIndex3 or follUp.caseIndex=:caseIndex4")
    Integer findCountByInquiryDateAndCaseIndex(@Param("inquiryToDate") Date inquiryToDate, @Param("inquiryFromDate") Date inquiryFromDate, @Param("caseIndex3")CaseIndex caseIndex3,@Param("caseIndex4")CaseIndex caseIndex4);

    @Query("select count(inq.id) from Inquiry inq where inq.inquiryDate between :inquiryToDate And :inquiryFromDate and inq.closingStatus=:closingStatus")
    Integer findCountByInquiryDateAndClosingStaus(@Param("inquiryToDate") Date inquiryToDate, @Param("inquiryFromDate") Date inquiryFromDate, @Param("closingStatus")FollowUpStatus followUpStatus);
}
