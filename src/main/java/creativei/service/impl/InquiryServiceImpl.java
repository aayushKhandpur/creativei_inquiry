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
import creativei.vo.InquiryCountVo;
import creativei.vo.ResponseObject;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import util.LocalizationUtil;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
    public ResponseObject getInquiryCount() throws ParseException {
        InquiryCountVo inquiryCountVo=null;
        try {
            inquiryCountVo= new InquiryCountVo();
            Date date=new Date();
            inquiryCountVo.setDailyCount(getDailyCount(date));
            inquiryCountVo.setWeekCount(getWeeklyCount(date));
            inquiryCountVo.setMonthCount(getMonthlyCount(date));
            inquiryCountVo.setHotLeadCount(getHotLeadCount(date));
            inquiryCountVo.setEnrolledCount(getEnrolledCount(date));
            return ResponseObject.getResponse(inquiryCountVo);
        }catch (Exception e){
            logger.error("Cause: "+e.getCause().getCause().getMessage());
            return ResponseObject.getResponse(ExceptionType.RESULTSET_GENERATION_EXCEPTION.getMessage(),ExceptionType.RESULTSET_GENERATION_EXCEPTION.getCode());
        }
    }


    private Integer getDailyCount(Date date) throws ParseException {
        logger.info("getDailyCount method");
        Date inquiryToDate=LocalizationUtil.getDateWithStartingTime(date);
        Date inquiryFromDate=new Date();
        return inquiryCustomDao.findCountByInquiryDate(inquiryFromDate, inquiryToDate);
    }

    private Integer getWeeklyCount(Date date) throws ParseException {
        logger.info("getWeeklyCount method");
        Calendar givenDate = Calendar.getInstance();
        givenDate.setTime(date);
        givenDate.setFirstDayOfWeek(Calendar.MONDAY);
        Calendar weekStartDate = (Calendar)givenDate.clone();
        weekStartDate.add(Calendar.DAY_OF_WEEK,
                weekStartDate.getFirstDayOfWeek() - weekStartDate.get(Calendar.DAY_OF_WEEK));
        weekStartDate.set(Calendar.HOUR_OF_DAY, 0);
        weekStartDate.set(Calendar.MINUTE, 0);
        Calendar weekEndDate = (Calendar) weekStartDate.clone();
        weekEndDate.add(Calendar.DAY_OF_YEAR, 6);
        Integer weeklyCount = inquiryCustomDao.findCountByInquiryDate(weekStartDate.getTime(), LocalizationUtil.setEodTime(weekEndDate));
        return weeklyCount;
    }

    private Integer getMonthlyCount(Date date) throws ParseException {
        logger.info("getMonthlyCount method");
        Date inquiryToDate=LocalizationUtil.getMonthStartingDate(date);
        Date inquiryFromDate=date;
        return inquiryCustomDao.findCountByInquiryDate(inquiryFromDate, inquiryToDate);
    }

    private Integer getHotLeadCount(Date date) throws ParseException {
        logger.info("getHotLeadCount method");
        Date inquiryToDate=LocalizationUtil.getMonthStartingDate(date);
        Date inquiryFromDate=date;
        List<CaseIndex> caseIndices=new ArrayList<CaseIndex>(){{
            add(CaseIndex.LIKELY);
            add(CaseIndex.HOT_LEAD);
        }};
        return inquiryCustomDao.findHotLeadsInAMonth(inquiryFromDate, inquiryToDate,caseIndices);
    }

    private Integer getEnrolledCount(Date date) throws ParseException {
        logger.info("getEnrolledCount method");
        Date inquiryToDate=LocalizationUtil.getMonthStartingDate(date);
        Date inquiryFromDate=date;
        return inquiryCustomDao.findEnrollementInAMonth(inquiryFromDate, inquiryToDate, FollowUpStatus.ENROLLED);
    }
}
