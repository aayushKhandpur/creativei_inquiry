package creativei.service;

import creativei.entity.Inquiry;
import creativei.entity.InquiryAddress;

import java.util.List;

/**
 * Created by user on 12/17/2017.
 */
public interface InquiryAddressService {
    List<InquiryAddress> getAll();
    InquiryAddress getById(Inquiry inquiry);
    InquiryAddress create(InquiryAddress inquiryAddress);
    InquiryAddress createAll(List<InquiryAddress> inquiryAddresses);
    InquiryAddress update(InquiryAddress inquiryAddress);
    InquiryAddress updateAll(List<InquiryAddress> inquiryAddresses);
}
