package creativei.service.impl;

import creativei.dao.InquiryCustomDao;
import creativei.entity.Inquiry;
import creativei.enums.*;
import creativei.exception.DataIntegrityException;
import creativei.exception.InvalidParamRequest;
import creativei.exception.NoDataAvailable;
import creativei.service.InquiryService;
import creativei.vo.FilterVo;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service("InquiryService")
public class InquiryServiceImpl implements InquiryService {
    private static final Logger logger = LoggerFactory.getLogger(InquiryService.class);

    @Autowired
    private InquiryCustomDao inquiryCustomDao;

    @Override
    public List<Inquiry> getAll() {
        return inquiryCustomDao.findAll();
    }

    @Override
    public List<Inquiry> getByStatus(InquiryStatus status) throws NoDataAvailable {
        List<Inquiry> inquiries = inquiryCustomDao.findByInquiryStatus(status);
        if (inquiries.size() == 0) {
            throw new NoDataAvailable(ExceptionType.DATA_NOT_AVAILABLE.getMessage());
        }
        return inquiries;
    }

    @Override
    public Inquiry getById(Long id) throws NoDataAvailable {
        logger.info("Inquiry getById");
        Inquiry inquiry = inquiryCustomDao.findOne(id);
        if (inquiry == null) {
            throw new NoDataAvailable(ExceptionType.DATA_NOT_AVAILABLE.getMessage());
        }
        return inquiry;
    }

    @Override
    public Inquiry getByName(String name) {
        return null;
    }

    @Override
    public Inquiry create(Inquiry inquiry) throws DataIntegrityException, InvalidParamRequest {
        logger.info("Inquiry Create");
        try {
            return inquiryCustomDao.save(inquiry);
        } catch (DataIntegrityViolationException de) {
            logger.error(de.getMessage(), de);
            if (de.getCause() instanceof ConstraintViolationException) {
                ConstraintViolationException ce = (ConstraintViolationException) de.getCause();
                if (ce.getConstraintName() == null)
                    throw new InvalidParamRequest(ce.getCause().getMessage());
            }
            throw new DataIntegrityException(de.getMessage());
        }
    }

    @Override
    public Inquiry createAll(List<Inquiry> inquiries) {
        return null;
    }

    @Override
    public Inquiry update(Inquiry inquiry) throws DataIntegrityException, InvalidParamRequest {
        logger.info("Inquiry Create");
        try {
            return inquiryCustomDao.save(inquiry);
        } catch (DataIntegrityViolationException de) {
            logger.error(de.getMessage(), de);
            if (de.getCause() instanceof ConstraintViolationException) {
                ConstraintViolationException ce = (ConstraintViolationException) de.getCause();
                if (ce.getConstraintName() == null)
                    throw new InvalidParamRequest(ce.getCause().getMessage());
            }
            throw new DataIntegrityException(de.getMessage());
        }
    }

    @Override
    public Inquiry updateAll(List<Inquiry> inquiries) {
        return null;
    }

    @Override
    public List<Inquiry> getAllByFilter(FilterVo filterVo) {
        InquiryStatus status = InquiryStatus.stringToEnum(filterVo.getInquiryVo().getInquiryStatus());
        CaseIndex caseIndex = CaseIndex.stringToEnum(filterVo.getFollowUpVo().getCaseIndex());
        Long cityId = filterVo.getCityVo().getId();
        return inquiryCustomDao.getFilteredInquiries(status, caseIndex, cityId);
    }
}
