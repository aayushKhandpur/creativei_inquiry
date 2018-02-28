package creativei.service.impl;

import creativei.dao.InquiryCustomDao;
import creativei.entity.FollowUp;
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
import util.LocalizationUtil;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    public List<Inquiry> getUnattendedInquiry(String boolParam, String statusParam) {
        Boolean isAttended;
        isAttended=boolParam.equalsIgnoreCase("false")?false:true;
        InquiryStatus inquiryStatus=InquiryStatus.stringToEnum(statusParam);
        return inquiryCustomDao.findByInquiryStatusAndIsAttended(inquiryStatus,isAttended);
    }

    @Override
    public List<Inquiry> getAllByFilter(FilterVo filterVo) {
        InquiryStatus status = InquiryStatus.stringToEnum(filterVo.getInquiryVo().getInquiryStatus());
        CaseIndex caseIndex = CaseIndex.stringToEnum(filterVo.getFollowUpVo().getCaseIndex());
        Long cityId = filterVo.getCityVo().getId();
        return inquiryCustomDao.findByFilters(status, caseIndex, cityId);
    }

    @Override
    public Integer getDailyCount() throws ParseException {
        String date1= LocalizationUtil.getFormattedDate(new Date());
        Date inquiryToDate=LocalizationUtil.stringToDateConverter(date1);
        Date inquiryFromDate=new Date();
        return inquiryCustomDao.findCountByInquiryDate(inquiryToDate,inquiryFromDate);
    }

    @Override
    public Integer getWeeklyCount() throws ParseException {
        Date date=new Date();
        Date inquiryToDate=LocalizationUtil.getWeekStartingDate(date);
        Date inquiryFromDate=date;
        return inquiryCustomDao.findCountByInquiryDate(inquiryToDate,inquiryFromDate);
    }

    @Override
    public Integer getMonthlyCount() throws ParseException {
        Date date=new Date();
        Date inquiryToDate=LocalizationUtil.getMonthStartingDate(date);
        Date inquiryFromDate=date;
        return inquiryCustomDao.findCountByInquiryDate(inquiryToDate,inquiryFromDate);
    }

    @Override
    public Integer getHotLeadCount() throws ParseException {
        Date date=new Date();
        Date inquiryToDate=LocalizationUtil.getMonthStartingDate(date);
        Date inquiryFromDate=date;
        CaseIndex caseIndex3=CaseIndex.stringToEnum("likely");
        CaseIndex caseIndex4=CaseIndex.stringToEnum("Hot Lead");
        return inquiryCustomDao.findHotLeadsInAMonth(inquiryToDate,inquiryFromDate,caseIndex3,caseIndex4);
    }

    @Override
    public Integer getEnrolledCount() throws ParseException {
        Date date=new Date();
        Date inquiryToDate=LocalizationUtil.getMonthStartingDate(date);
        Date inquiryFromDate=date;
        return inquiryCustomDao.findEnrollementInAMonth(inquiryToDate,inquiryFromDate, FollowUpStatus.ENROLLED);
    }
}
