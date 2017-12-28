package creativei.service.impl;

import creativei.dao.InquiryAddressDao;
import creativei.entity.Inquiry;
import creativei.entity.InquiryAddress;
import creativei.service.InquiryAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 12/17/2017.
 */
@Service("InquiryAddressService")
public class InquiryAddressServiceImpl implements InquiryAddressService {
    @Autowired
    InquiryAddressDao inquiryAddressDao;

    @Override
    public List<InquiryAddress> getAll() {
        return null;
    }

    @Override
    public InquiryAddress getById(Inquiry inquiry) {
        return null;
    }

    @Override
    public InquiryAddress create(InquiryAddress inquiryAddress) {
        return inquiryAddressDao.save(inquiryAddress);
    }

    @Override
    public InquiryAddress createAll(List<InquiryAddress> inquiryAddresses) {
        return null;
    }

    @Override
    public InquiryAddress update(InquiryAddress inquiryAddress) {
        return null;
    }

    @Override
    public InquiryAddress updateAll(List<InquiryAddress> inquiryAddresses) {
        return null;
    }
}

