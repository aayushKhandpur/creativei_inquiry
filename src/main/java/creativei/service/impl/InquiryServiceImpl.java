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
    public Inquiry getById(Long id) {
        return null;
    }

    @Override
    public Inquiry getByName(String name) {
        return null;
    }

    @Override
    public Inquiry create(Inquiry inquiry) {
        return null;
    }

    @Override
    public Inquiry createAll(List<Inquiry> inquiries) {
        return null;
    }

    @Override
    public Inquiry update(Inquiry inquiry) {
        return null;
    }

    @Override
    public Inquiry updateAll(List<Inquiry> inquiries) {
        return null;
    }
}
