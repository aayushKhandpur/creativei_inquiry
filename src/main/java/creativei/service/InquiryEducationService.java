package creativei.service;

import creativei.entity.Inquiry;
import creativei.entity.InquiryEducation;
import creativei.exception.DataIntegrityException;
import creativei.exception.InvalidParamRequest;
import creativei.exception.UniqueConstraintViolationException;

import java.util.List;

/**
 * Created by user on 12/19/2017.
 */
public interface InquiryEducationService {
    List<InquiryEducation> getAll();
    InquiryEducation getById(Inquiry inquiry);
    InquiryEducation create(InquiryEducation inquiryEducation ) throws InvalidParamRequest,DataIntegrityException;
    InquiryEducation createAll(List<InquiryEducation> inquiryEducations);
    InquiryEducation update(InquiryEducation inquiryEducation) throws InvalidParamRequest,DataIntegrityException;
    InquiryEducation updateAll(List<InquiryEducation> inquiryEducations);
}
