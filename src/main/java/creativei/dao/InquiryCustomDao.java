package creativei.dao;

import creativei.entity.Inquiry;
import creativei.enums.InquiryStatus;

import java.util.List;

public interface InquiryCustomDao {
    List<Inquiry> findByInquiryStatus(InquiryStatus status);
    List<Inquiry> getFilteredInquiries(InquiryStatus status);
}
