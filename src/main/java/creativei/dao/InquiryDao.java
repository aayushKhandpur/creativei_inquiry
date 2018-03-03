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

    @Query("select count(inq.id) from Inquiry inq where inq.inquiryDate between :inquiryToDate And :inquiryFromDate")
    Integer findCountByInquiryDate(@Param("inquiryToDate") Date inquiryToDate, @Param("inquiryFromDate") Date inquiryFromDate);

    @Query("select count(inq.id) from Inquiry inq join inq.followUps follUp  where inq.inquiryDate between :inquiryToDate And :inquiryFromDate and (follUp.caseIndex in (:caseIndex))")
    Integer findCountByInquiryDateAndCaseIndex(@Param("inquiryToDate") Date inquiryToDate, @Param("inquiryFromDate") Date inquiryFromDate, @Param("caseIndex") List<CaseIndex> caseIndex);

    @Query("select count(inq.id) from Inquiry inq where inq.inquiryDate between :inquiryToDate And :inquiryFromDate and inq.closingStatus=:closingStatus")
    Integer findCountByInquiryDateAndClosingStaus(@Param("inquiryToDate") Date inquiryToDate, @Param("inquiryFromDate") Date inquiryFromDate, @Param("closingStatus")FollowUpStatus followUpStatus);
}
