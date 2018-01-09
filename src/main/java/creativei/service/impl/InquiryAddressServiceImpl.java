package creativei.service.impl;

import creativei.dao.InquiryAddressDao;
import creativei.entity.Inquiry;
import creativei.entity.InquiryAddress;
import creativei.exception.DataIntegrityException;
import creativei.exception.InvalidParamRequest;
import creativei.exception.UniqueConstraintViolationException;
import creativei.service.BranchService;
import creativei.service.InquiryAddressService;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("InquiryAddressService")
public class InquiryAddressServiceImpl implements InquiryAddressService {
    private static final Logger logger = LoggerFactory.getLogger(BranchService.class);

    @Autowired
    InquiryAddressDao inquiryAddressDao;

    @Override
    public List<InquiryAddress> getAll() {
        return null;
    }

    @Override
    public InquiryAddress getById(Inquiry inquiry) {
        return null;
    }

    @Override
    public InquiryAddress create(InquiryAddress inquiryAddress)throws  DataIntegrityException ,InvalidParamRequest {
        try {
            return inquiryAddressDao.save(inquiryAddress);
        }catch (DataIntegrityViolationException de){
            logger.error(de.getMessage(), de);
            if(de.getCause() instanceof ConstraintViolationException){
                ConstraintViolationException ce = (ConstraintViolationException) de.getCause();
                if(ce.getConstraintName()==null)
                    throw new InvalidParamRequest("Required Field Can not be Empty");
            }
            throw new DataIntegrityException(de.getMessage());
        }
    }

    @Override
    public InquiryAddress createAll(List<InquiryAddress> inquiryAddresses) {
        return null;
    }

    @Override
    public InquiryAddress update(InquiryAddress inquiryAddress) throws  DataIntegrityException,InvalidParamRequest  {
        try {
            return inquiryAddressDao.save(inquiryAddress);
        }catch (DataIntegrityViolationException de){
            logger.error(de.getMessage(), de);
            if(de.getCause() instanceof ConstraintViolationException){
                ConstraintViolationException ce = (ConstraintViolationException) de.getCause();
                if(ce.getConstraintName()==null)
                    throw new InvalidParamRequest("Required Field Can not be Empty");
            }
            throw new DataIntegrityException(de.getMessage());
        }
    }

    @Override
    public InquiryAddress updateAll(List<InquiryAddress> inquiryAddresses) {
        return null;
    }
}

