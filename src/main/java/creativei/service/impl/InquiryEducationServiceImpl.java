package creativei.service.impl;

import creativei.dao.InquiryEducationDao;
import creativei.entity.Inquiry;
import creativei.entity.InquiryEducation;
import creativei.exception.DataIntegrityException;
import creativei.exception.UniqueConstraintViolationException;
import creativei.service.InquiryEducationService;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("InquiryEducationService")
public class InquiryEducationServiceImpl implements InquiryEducationService {
    public static final Logger logger= LoggerFactory.getLogger(InquiryEducation.class);
    @Autowired
    InquiryEducationDao inquiryEducationDao;
    @Override
    public List<InquiryEducation> getAll() {
        return null;
    }

    @Override
    public InquiryEducation getById(Inquiry inquiry) {
        return null;
    }

    @Override
    public InquiryEducation create(InquiryEducation inquiryEducation) throws UniqueConstraintViolationException,DataIntegrityException {
        try{
           return inquiryEducationDao.save(inquiryEducation);
        }catch(DataIntegrityViolationException de){
            logger.error(de.getMessage(), de);
            if(de.getCause() instanceof ConstraintViolationException){
                ConstraintViolationException ce = (ConstraintViolationException) de.getCause();
                throw UniqueConstraintViolationException.getInstance(ce.getConstraintName(), ce.getMessage());
            }
            throw new DataIntegrityException(de.getMessage());
        }
    }

    @Override
    public InquiryEducation createAll(List<InquiryEducation> inquiryEducations) {
        return null;
    }

    @Override
    public InquiryEducation update(InquiryEducation inquiryEducation) throws UniqueConstraintViolationException,DataIntegrityException {
        try{
            return inquiryEducationDao.save(inquiryEducation);
        }catch(DataIntegrityViolationException de){
            logger.error(de.getMessage(), de);
            if(de.getCause() instanceof ConstraintViolationException){
                ConstraintViolationException ce = (ConstraintViolationException) de.getCause();
                throw UniqueConstraintViolationException.getInstance(ce.getConstraintName(), ce.getMessage());
            }
            throw new DataIntegrityException(de.getMessage());
        }
    }

    @Override
    public InquiryEducation updateAll(List<InquiryEducation> inquiryEducations) {
        return null;
    }
}
