package creativei.dao;

import creativei.entity.Inquiry;

import java.util.List;

public interface InquiryCustomDao {
    List<Inquiry> getFilteredInquiries();
}
