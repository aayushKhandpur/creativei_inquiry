package creativei.service;

import creativei.entity.Inquiry;
import creativei.entity.InquiryGuardian;

import java.util.List;

/**
 * Created by user on 12/19/2017.
 */
public interface InquiryGuardianService {
    List<InquiryGuardian> getAll();
    InquiryGuardian getById(Inquiry inquiry);
    InquiryGuardian create(InquiryGuardian inquiryGuardian);
    InquiryGuardian createAll(List<InquiryGuardian> inquiryGuardians);
    InquiryGuardian upadate(InquiryGuardian inquiryGuardian);
    InquiryGuardian updateAll(List<InquiryGuardian> inquiryGuardians);
}

