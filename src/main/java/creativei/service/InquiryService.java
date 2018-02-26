package creativei.service;

import creativei.entity.Inquiry;
import creativei.enums.InquiryStatus;
import creativei.exception.DataIntegrityException;
import creativei.exception.InvalidParamRequest;
import creativei.exception.NoDataAvailable;
import creativei.vo.FilterVo;

import java.util.List;

/**
 * Created by user on 12/16/2017.
 */
public interface InquiryService {
    List<Inquiry> getAll();
    List<Inquiry> getByStatus(InquiryStatus status)throws NoDataAvailable;
    Inquiry getById(Long id) throws NoDataAvailable;
    Inquiry getByName(String name);
    Inquiry create (Inquiry inquiry)throws  DataIntegrityException,InvalidParamRequest;
    Inquiry createAll(List<Inquiry> inquiries);
    Inquiry update(Inquiry inquiry )throws  DataIntegrityException,InvalidParamRequest;
    Inquiry updateAll(List<Inquiry> inquiries);
    List<Inquiry> getUnattendedInquiry(String boolParam,String statusParam);
    List<Inquiry> getAllByFilter(FilterVo filterVo);

}
