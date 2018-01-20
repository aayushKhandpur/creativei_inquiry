package creativei.manager;


import creativei.entity.Inquiry;
import creativei.vo.AddressVo;
import creativei.vo.InquiryServerInfoVo;
import creativei.vo.InquiryVo;
import creativei.vo.ResponseObject;

import java.util.List;

/**
 * Created by user on 12/16/2017.
 */
public interface InquiryManager {
    ResponseObject getAll();
    ResponseObject create(InquiryVo inquiryVo);
    ResponseObject getById(Long id);
    ResponseObject getByName(String name);
    ResponseObject createAll(List<Inquiry> inquiries);
    ResponseObject update(InquiryVo inquiryVo);
    ResponseObject updateAll(List<Inquiry> inquiries);
    ResponseObject getAllEnum();
}
