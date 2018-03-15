package creativei.dao;

import creativei.entity.Inquiry;
import creativei.enums.CaseIndex;
import creativei.enums.FollowUpStatus;
import creativei.enums.InquiryStatus;
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

    @Query("select count(inq.id) from Inquiry inq where inq.inquiryDate between :inquiryFromDate And :inquiryToDate")
    Integer findCountByInquiryDate(@Param("inquiryFromDate") Date inquiryFromDate, @Param("inquiryToDate") Date inquiryToDate);

    @Query("select count(inq.id) from Inquiry inq join inq.followUps follUp  where inq.inquiryDate between :inquiryFromDate And :inquiryToDate and (follUp.caseIndex in (:caseIndex))")
    Integer findCountByInquiryDateAndCaseIndex(@Param("inquiryFromDate") Date inquiryFromDate, @Param("inquiryToDate") Date inquiryToDate, @Param("caseIndex") List<CaseIndex> caseIndex);

    @Query("select count(inq.id) from Inquiry inq where inq.inquiryDate between :inquiryFromDate And :inquiryToDate and inq.closingStatus=:closingStatus")
    Integer findCountByInquiryDateAndClosingStaus(@Param("inquiryFromDate") Date inquiryFromDate, @Param("inquiryToDate") Date inquiryToDate, @Param("closingStatus")FollowUpStatus followUpStatus);
}
