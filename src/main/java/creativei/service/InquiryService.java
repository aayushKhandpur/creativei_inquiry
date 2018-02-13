package creativei.service;

import creativei.entity.Inquiry;
import creativei.enums.InquiryStatus;
import creativei.exception.DataIntegrityException;
import creativei.exception.InvalidParamRequest;
import creativei.exception.NoDataAvailable;
import creativei.exception.UniqueConstraintViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 12/16/2017.
 */
public interface InquiryService {
    List<Inquiry> getAll();
    List<Inquiry> getByStatus(InquiryStatus status)throws NoDataAvailable;
    Inquiry getById(Long id) throws NoDataAvailable;
    Inquiry getByName(String name);
    Inquiry create (Inquiry inquiry)throws UniqueConstraintViolationException, DataIntegrityException,InvalidParamRequest;
    Inquiry createAll(List<Inquiry> inquiries);
    Inquiry update(Inquiry inquiry )throws UniqueConstraintViolationException, DataIntegrityException,InvalidParamRequest;
    Inquiry updateAll(List<Inquiry> inquiries);

}
