package creativei.service;

import creativei.entity.Inquiry;
import creativei.entity.InquiryAddress;
import creativei.exception.DataIntegrityException;
import creativei.exception.UniqueConstraintViolationException;

import java.util.List;

/**
 * Created by user on 12/17/2017.
 */
public interface InquiryAddressService {
    List<InquiryAddress> getAll();
    InquiryAddress getById(Inquiry inquiry);
    InquiryAddress create(InquiryAddress inquiryAddress) throws UniqueConstraintViolationException, DataIntegrityException;
    InquiryAddress createAll(List<InquiryAddress> inquiryAddresses);
    InquiryAddress update(InquiryAddress inquiryAddress) throws UniqueConstraintViolationException, DataIntegrityException;
    InquiryAddress updateAll(List<InquiryAddress> inquiryAddresses);
}
