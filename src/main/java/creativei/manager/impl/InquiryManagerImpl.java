package creativei.manager.impl;

import creativei.entity.Inquiry;
import creativei.manager.InquiryManager;
import creativei.service.BranchService;
import creativei.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by user on 12/16/2017.
 */
public class InquiryManagerImpl implements InquiryManager {
    @Autowired
    InquiryService inquiryService;
    @Override
    public List<Inquiry> getAll() {
        return null;
    }

    @Override
    public Inquiry create(Inquiry inquiry) {
        return inquiryService.create(inquiry);
    }

    @Override
    public Inquiry findInquiry(Long id) {
        return null;
    }
}
