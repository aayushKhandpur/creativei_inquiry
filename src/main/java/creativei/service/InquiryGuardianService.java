package creativei.service;

import creativei.entity.Inquiry;
import creativei.entity.InquiryGuardian;
import creativei.exception.DataIntegrityException;
import creativei.exception.UniqueConstraintViolationException;

import java.util.List;

/**
 * Created by user on 12/19/2017.
 */
public interface InquiryGuardianService {
    List<InquiryGuardian> getAll();
    InquiryGuardian getById(Inquiry inquiry);
    InquiryGuardian create(InquiryGuardian inquiryGuardian) throws UniqueConstraintViolationException,DataIntegrityException;
    InquiryGuardian createAll(List<InquiryGuardian> inquiryGuardians);
    InquiryGuardian upadate(InquiryGuardian inquiryGuardian)throws UniqueConstraintViolationException,DataIntegrityException;
    InquiryGuardian updateAll(List<InquiryGuardian> inquiryGuardians);
}

