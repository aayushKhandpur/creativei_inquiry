package creativei.service;

import creativei.entity.Inquiry;
import creativei.exception.DataIntegrityException;
import creativei.exception.UniqueConstraintViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by user on 12/16/2017.
 */
public interface InquiryService {
    List<Inquiry> getAll();
    Inquiry getById(Long id);
    Inquiry getByName(String name);
    Inquiry create (Inquiry inquiry)throws UniqueConstraintViolationException, DataIntegrityException;
    Inquiry createAll(List<Inquiry> inquiries);
    Inquiry update(Inquiry inquiry);
    Inquiry updateAll(List<Inquiry> inquiries);
}
