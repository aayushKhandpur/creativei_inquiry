package creativei.manager.impl;

import creativei.entity.Inquiry;
import creativei.manager.InquiryManager;
import creativei.service.BranchService;
import creativei.service.InquiryService;
import creativei.vo.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by user on 12/16/2017.
 */
public class InquiryManagerImpl implements InquiryManager {
    @Autowired
    InquiryService inquiryService;

    @Override
    public ResponseObject getAll() {
        return null;
    }

    @Override
    public ResponseObject create(Inquiry inquiry) {
        return null;
    }

    @Override
    public ResponseObject getById(Long id) {
        return null;
    }

    @Override
    public ResponseObject getByName(String name) {
        return null;
    }

    @Override
    public ResponseObject createAll(List<Inquiry> inquiries) {
        return null;
    }

    @Override
    public ResponseObject update(Inquiry inquiry) {
        return null;
    }

    @Override
    public ResponseObject updateAll(List<Inquiry> inquiries) {
        return null;
    }
}
