package creativei.service;

import creativei.entity.Inquiry;
import creativei.entity.InquiryGuardian;
import creativei.exception.DataIntegrityException;
import creativei.exception.InvalidParamRequest;
import creativei.exception.UniqueConstraintViolationException;

import java.util.List;

public interface InquiryGuardianService {
    List<InquiryGuardian> getAll();
    InquiryGuardian getById(Inquiry inquiry);
    InquiryGuardian create(InquiryGuardian inquiryGuardian) throws InvalidParamRequest,DataIntegrityException;
    InquiryGuardian createAll(List<InquiryGuardian> inquiryGuardians);
    InquiryGuardian upadate(InquiryGuardian inquiryGuardian)throws InvalidParamRequest,DataIntegrityException;
    InquiryGuardian updateAll(List<InquiryGuardian> inquiryGuardians);
}

