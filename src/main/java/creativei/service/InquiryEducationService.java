package creativei.service;

import creativei.entity.Inquiry;
import creativei.entity.InquiryEducation;

import java.util.List;

/**
 * Created by user on 12/19/2017.
 */
public interface InquiryEducationService {
    List<InquiryEducation> getAll();
    InquiryEducation getById(Inquiry inquiry);
    InquiryEducation create(InquiryEducation inquiryEducation );
    InquiryEducation createAll(List<InquiryEducation> inquiryEducations);
    InquiryEducation update(InquiryEducation inquiryEducation);
    InquiryEducation updateAll(List<InquiryEducation> inquiryEducations);
}
