package creativei.service.impl;

import creativei.dao.BranchDao;
import creativei.dao.InquiryDao;
import creativei.entity.Branch;
import creativei.entity.Inquiry;
import creativei.enums.ExceptionType;
import creativei.enums.InquiryStatus;
import creativei.exception.DataIntegrityException;
import creativei.exception.InvalidParamRequest;
import creativei.exception.NoDataAvailable;
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
    public List<Inquiry> getByStatus(InquiryStatus status) throws NoDataAvailable {
        List<Inquiry> inquiries = inquiryDao.findByInquiryStatus(status);
        if (inquiries.size() == 0) {
            throw new NoDataAvailable(ExceptionType.DATA_NOT_AVAILABLE.getMessage());
        }
        return inquiries;
    }

    @Override
    public Inquiry getById(Long id) throws NoDataAvailable {
        logger.info("Inquiry getById");
        Inquiry inquiry = inquiryDao.findOne(id);
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
    public Inquiry create(Inquiry inquiry) throws  DataIntegrityException, InvalidParamRequest {
        logger.info("Inquiry Create");
        try {
            return inquiryDao.save(inquiry);
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
    public Inquiry update(Inquiry inquiry) throws  DataIntegrityException, InvalidParamRequest {
        logger.info("Inquiry Create");
        try {
            return inquiryDao.save(inquiry);
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
    public List<Inquiry> getUnattendedInquiry(String boolParam, String statusParam) {
        Boolean isAttended;
        isAttended=boolParam.equalsIgnoreCase("false")?false:true;
        InquiryStatus inquiryStatus=InquiryStatus.stringToEnum(statusParam);
        return inquiryDao.findByInquiryStatusAndIsAttended(inquiryStatus,isAttended);
    }
}
