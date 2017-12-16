package creativei.manager;


import creativei.entity.Inquiry;

import java.util.List;

/**
 * Created by user on 12/16/2017.
 */
public interface InquiryManager {
    List<Inquiry> getAll();
    Inquiry create(Inquiry inquiry);
    Inquiry findInquiry(Long id) ;
}
