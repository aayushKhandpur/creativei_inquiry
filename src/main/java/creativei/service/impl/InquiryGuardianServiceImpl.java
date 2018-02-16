package creativei.service.impl;

import creativei.dao.InquiryGuardianDao;
import creativei.entity.Inquiry;
import creativei.entity.InquiryEducation;
import creativei.entity.InquiryGuardian;
import creativei.exception.DataIntegrityException;
import creativei.exception.InvalidParamRequest;
import creativei.exception.UniqueConstraintViolationException;
import creativei.service.InquiryGuardianService;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("InquiryGuardianService")
public class InquiryGuardianServiceImpl implements InquiryGuardianService {
    public static final Logger logger = LoggerFactory.getLogger(InquiryGuardian.class);
    @Autowired
    InquiryGuardianDao inquiryGuardianDao;

    @Override
    public List<InquiryGuardian> getAll() {
        return null;
    }

    @Override
    public InquiryGuardian getById(Inquiry inquiry) {
        return null;
    }

    @Override
    public InquiryGuardian create(InquiryGuardian inquiryGuardian) throws InvalidParamRequest, DataIntegrityException {
        logger.info("Inquiry Guardian create");
        try {
            return inquiryGuardianDao.save(inquiryGuardian);
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
    public InquiryGuardian createAll(List<InquiryGuardian> inquiryGuardians) {
        return null;
    }

    @Override
    public InquiryGuardian upadate(InquiryGuardian inquiryGuardian) throws InvalidParamRequest, DataIntegrityException {
        logger.info("Inquiry Guardian update");
        try {
            return inquiryGuardianDao.save(inquiryGuardian);
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
    public InquiryGuardian updateAll(List<InquiryGuardian> inquiryGuardians) {
        return null;
    }
}
