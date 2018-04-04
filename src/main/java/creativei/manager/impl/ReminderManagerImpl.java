package creativei.manager.impl;

import creativei.entity.Reminder;
import creativei.enums.ExceptionType;
import creativei.exception.InvalidParamRequest;
import creativei.helper.ResponseHelper;
import creativei.manager.ReminderManager;
import creativei.service.ReminderService;
import creativei.vo.ReminderVo;
import creativei.vo.ResponseObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import creativei.util.LocalizationUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class ReminderManagerImpl implements ReminderManager {

    @Autowired
    ReminderService reminderService;

    Logger logger= LoggerFactory.getLogger(ReminderManagerImpl.class);
    @Override
    public ResponseObject create(ReminderVo reminderVo) {
        logger.info("Create Reminder method");
        try {
            Reminder reminder=new Reminder(reminderVo);
            reminder=reminderService.create(reminder);
            reminderVo= ResponseHelper.getCreateReminderResponse(reminder);
            return ResponseObject.getResponse(reminderVo);
        }catch (InvalidParamRequest invalidParamRequest) {
            logger.error(invalidParamRequest.getMessage(), invalidParamRequest);
            return ResponseObject.getResponse(ExceptionType.INVALID_METHOD_PARAM.getMessage(),ExceptionType.INVALID_METHOD_PARAM.getCode());
        }catch (ParseException e) {
            logger.error(e.getMessage(),e);
            return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(),ExceptionType.GENERAL_ERROR.getCode());
        }
    }

    @Override
    public ResponseObject getReminderByDateRange(String fromDateStr, String toDateStr) {
        logger.info("Get Reminder by date range Method");
        List<Reminder> reminders= null;
        Date fromDate=null;
        Date toDate=null;
        try {
            if(StringUtils.isNotBlank(fromDateStr))
                fromDate=LocalizationUtil.stringToDate(fromDateStr);
            if(StringUtils.isNotBlank(toDateStr))
                toDate=LocalizationUtil.setEodTime(LocalizationUtil.stringToDate(toDateStr));
            reminders = reminderService.getReminderByDateRange(fromDate,toDate);
            List<ReminderVo> reminderVos=ResponseHelper.getReminderByDateRangeResponse(reminders);
            return ResponseObject.getResponse(reminderVos);
        } catch (ParseException e) {
            logger.error(e.getMessage(),e);
            return ResponseObject.getResponse(ExceptionType.INVALID_METHOD_PARAM.getMessage(),ExceptionType.INVALID_METHOD_PARAM.getCode());
        } catch (InvalidParamRequest invalidParamRequest) {
            logger.error(invalidParamRequest.getMessage(),invalidParamRequest);
            return ResponseObject.getResponse(ExceptionType.INVALID_METHOD_PARAM.getMessage(),ExceptionType.INVALID_METHOD_PARAM.getCode());
        }catch (Exception e){
            logger.error(e.getMessage()+" Requested Parameter: "+toDate+" "+fromDate ,e);
            return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(),ExceptionType.GENERAL_ERROR.getCode());
        }
    }
}
