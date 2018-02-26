package creativei.manager;


import creativei.entity.Inquiry;
import creativei.enums.InquiryStatus;
import creativei.vo.*;

import java.util.List;

public interface InquiryManager {
    ResponseObject getAll();

    ResponseObject getByStatus(InquiryStatus status);

    ResponseObject create(InquiryVo inquiryVo);

    ResponseObject getById(Long id);

    ResponseObject getByName(String name);

    ResponseObject createAll(List<Inquiry> inquiries);

    ResponseObject update(InquiryVo inquiryVo);

    ResponseObject updateAll(List<Inquiry> inquiries);

    ResponseObject getInquiryServerInfo();

    ResponseObject getUnattendedInquiry(String boolParam,String statusParam);

    ResponseObject getAllByFilter(FilterVo filterVo);
}
