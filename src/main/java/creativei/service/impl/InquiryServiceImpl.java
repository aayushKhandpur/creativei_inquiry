package creativei.service.impl;

import creativei.dao.BranchDao;
import creativei.dao.InquiryDao;
import creativei.entity.Branch;
import creativei.entity.Inquiry;
import creativei.exception.DataIntegrityException;
import creativei.exception.InvalidParamRequest;
import creativei.exception.UniqueConstraintViolationException;
import creativei.service.BranchService;
import creativei.service.InquiryService;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Service("InquiryService")
public class InquiryServiceImpl implements InquiryService {
    private static final Logger logger = LoggerFactory.getLogger(InquiryService.class);
    @Autowired
    private InquiryDao inquiryDao;

    @Override
    public List<Inquiry> getAll() {
        return inquiryDao.findAll();
    }

    @Override
    public Inquiry getById(Long id) {
        return null;
    }

    @Override
    public Inquiry getByName(String name) {
        return null;
    }

    @Override
    public Inquiry create(Inquiry inquiry) throws UniqueConstraintViolationException, DataIntegrityException,InvalidParamRequest {
        try{
            return inquiryDao.save(inquiry);
        } catch (DataIntegrityViolationException de){
            logger.error(de.getMessage(), de);
            if(de.getCause() instanceof ConstraintViolationException){
                ConstraintViolationException ce = (ConstraintViolationException) de.getCause();
                if(ce.getConstraintName()==null)
                    throw new InvalidParamRequest("Required Field Can not be Empty");
                else
                    throw UniqueConstraintViolationException.getInstance(ce.getConstraintName(), ce.getMessage());
            }
            throw new DataIntegrityException(de.getMessage());
        }
    }

    @Override
    public Inquiry createAll(List<Inquiry> inquiries) {
        return null;
    }

    @Override
    public Inquiry update(Inquiry inquiry)throws UniqueConstraintViolationException, DataIntegrityException,InvalidParamRequest  {
        try{
            return inquiryDao.save(inquiry);
        }catch (DataIntegrityViolationException de){
            logger.error(de.getMessage(), de);
            if(de.getCause() instanceof ConstraintViolationException){
                ConstraintViolationException ce = (ConstraintViolationException) de.getCause();
                if(ce.getConstraintName()==null)
                    throw new InvalidParamRequest("Required Field Can not be Empty");
                else
                    throw UniqueConstraintViolationException.getInstance(ce.getConstraintName(), ce.getMessage());
            }
            throw new DataIntegrityException(de.getMessage());
        }
    }

    @Override
    public Inquiry updateAll(List<Inquiry> inquiries) {
        return null;
    }
}
