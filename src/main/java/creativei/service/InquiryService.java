package creativei.service;

import creativei.entity.Inquiry;

import java.util.List;

/**
 * Created by user on 12/16/2017.
 */
public interface InquiryService {
    List<Inquiry> getAll();
    Inquiry findInquery(Long id);
    Inquiry create(Inquiry inquiry);
}
