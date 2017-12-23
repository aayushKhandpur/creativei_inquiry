package creativei.manager;


import creativei.entity.Inquiry;
import creativei.vo.ResponseObject;

import java.util.List;

/**
 * Created by user on 12/16/2017.
 */
public interface InquiryManager {
    ResponseObject getAll();
    ResponseObject create(Inquiry inquiry);
    ResponseObject getById(Long id);
    ResponseObject getByName(String name);
    ResponseObject createAll(List<Inquiry> inquiries);
    ResponseObject update(Inquiry inquiry);
    ResponseObject updateAll(List<Inquiry> inquiries);
}
