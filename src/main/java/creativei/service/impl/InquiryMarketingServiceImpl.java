package creativei.service.impl;

import creativei.dao.InquiryMarketingDao;
import creativei.entity.Inquiry;
import creativei.entity.InquiryMarketing;
import creativei.exception.DataIntegrityException;
import creativei.exception.InvalidParamRequest;
import creativei.exception.UniqueConstraintViolationException;
import creativei.service.InquiryMarketingService;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("InquiryMarketingService")
public class InquiryMarketingServiceImpl implements InquiryMarketingService {
    public Logger logger = LoggerFactory.getLogger(InquiryMarketing.class);
    @Autowired
    InquiryMarketingDao inquiryMarketingDao;

    @Override
    public List<InquiryMarketing> getAll() {
        return null;
    }

    @Override
    public InquiryMarketing getById(Inquiry inquiry) {
        return null;
    }

    @Override
    public InquiryMarketing create(InquiryMarketing inquiryMarketing) throws InvalidParamRequest, DataIntegrityException {
        logger.info("Inquiry Marketing create");
        try {
            return inquiryMarketingDao.save(inquiryMarketing);
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
    public InquiryMarketing createAll(List<InquiryMarketing> inquiryMarketings) {
        return null;
    }

    @Override
    public InquiryMarketing update(InquiryMarketing inquiryMarketing) throws InvalidParamRequest, DataIntegrityException {
        logger.info("Inqiury Marketing update");
        try {
            return inquiryMarketingDao.save(inquiryMarketing);
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
    public InquiryMarketing updateAll(List<InquiryMarketing> inquiryMarketings) {
        return null;
    }
}
