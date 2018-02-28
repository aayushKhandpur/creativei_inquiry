package creativei.dao;

import creativei.entity.City;
import creativei.entity.FollowUp;
import creativei.entity.Inquiry;
import creativei.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface InquiryCustomDao {
    List<Inquiry> findByInquiryStatus(InquiryStatus status);

    List<Inquiry> findByFilters(InquiryStatus status, CaseIndex caseIndex, Long cityId);

    List<Inquiry> findByInquiryStatusAndIsAttended(InquiryStatus inquiryStatus,Boolean isAttended);

    Inquiry save(Inquiry inquiry);

    List<Inquiry> findAll();

    Inquiry findOne(Long aLong);

    Integer findCountByInquiryDate(Date inquiryToDate, Date inquiryDateFrom);

    Integer findHotLeadsInAMonth(Date inquiryToDate, Date inquiryFromDate,CaseIndex caseIndex3,CaseIndex caseIndex4);

    Integer findEnrollementInAMonth(Date inquiryToDate, Date inquiryFromDate, FollowUpStatus closingStatus);
}
