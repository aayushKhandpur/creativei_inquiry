package creativei.manager;


import creativei.entity.Inquiry;
import creativei.enums.InquiryStatus;
import creativei.vo.AddressVo;
import creativei.vo.InquiryServerInfoVo;
import creativei.vo.InquiryVo;
import creativei.vo.ResponseObject;

import java.util.List;

public interface InquiryManager {
    ResponseObject getAll();
    ResponseObject getByStatus(InquiryStatus status);
    ResponseObject create(InquiryVo inquiryVo);
    ResponseObject getById(Long id) ;
    ResponseObject getByName(String name);
    ResponseObject createAll(List<Inquiry> inquiries);
    ResponseObject update(InquiryVo inquiryVo);
    ResponseObject updateAll(List<Inquiry> inquiries);
    ResponseObject getAllEnum();
    ResponseObject getPincodes(String pincode);
    ResponseObject getLocalityDataByPincode(String pincode);
}
