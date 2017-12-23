package creativei.service;

import creativei.entity.Inquiry;
import creativei.entity.InquiryMarketing;

import java.util.List;

/**
 * Created by user on 12/19/2017.
 */
public interface InquiryMarketingService {
    List<InquiryMarketing> getAll();
    InquiryMarketing getById(Inquiry inquiry);
    InquiryMarketing create(InquiryMarketing inquiryMarketing);
    InquiryMarketing createAll(List<InquiryMarketing> inquiryMarketings);
    InquiryMarketing update(InquiryMarketing inquiryMarketing);
    InquiryMarketing updateAll(List<InquiryMarketing> inquiryMarketings);

}
