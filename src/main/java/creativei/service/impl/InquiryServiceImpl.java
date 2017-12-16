package creativei.service.impl;

import creativei.dao.InquiryDao;
import creativei.entity.Branch;
import creativei.entity.Inquiry;
import creativei.service.BranchService;
import creativei.service.InquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 12/16/2017.
 */
@Service("InquiryService")
public class InquiryServiceImpl implements InquiryService {
    @Autowired
    private InquiryDao inquiryDao;


    @Override
    public List<Inquiry> getAll() {
        return null;
    }

    @Override
    public Inquiry findInquery(Long id) {
        return null;
    }

    @Override
    public Inquiry create(Inquiry inquiry) {
        return inquiryDao.save(inquiry);
    }
}
