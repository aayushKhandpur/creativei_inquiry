package creativei.dao;

import creativei.entity.Inquiry;
import creativei.enums.*;

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

    Integer findHotLeadsInAMonth(Date inquiryToDate, Date inquiryFromDate,List<CaseIndex> caseIndices);

    Integer findEnrollementInAMonth(Date inquiryToDate, Date inquiryFromDate, FollowUpStatus closingStatus);
}
