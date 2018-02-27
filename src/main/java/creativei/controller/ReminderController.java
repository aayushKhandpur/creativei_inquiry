package creativei.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import creativei.entity.FollowUp;
import creativei.entity.Reminder;
import creativei.enums.ExceptionType;
import creativei.helper.RequestHelper;
import creativei.manager.ReminderManager;
import creativei.vo.ReminderDateVo;
import creativei.vo.ReminderVo;
import creativei.vo.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@CrossOrigin(origins = "http://localhost:8100")
@RestController

public class ReminderController {
    private static final Logger logger = LoggerFactory.getLogger(ReminderController.class);
    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    ReminderManager reminderManager;

    @PostMapping(value = "/reminder/create",produces = "application/json")
    public @ResponseBody
    ResponseObject createReminder(@RequestBody String reminderString, HttpServletRequest request){
        logger.info("CreateReminder method");
        try {
            if(RequestHelper.isEmptyRequestString(reminderString))
                return (ResponseObject.getResponse(ExceptionType.INVALID_METHOD_PARAM.getMessage(), ExceptionType.INVALID_METHOD_PARAM.getCode()));
            ReminderVo reminderVo= mapper.readValue(reminderString, ReminderVo.class);
            ResponseObject responseObject = reminderManager.create(reminderVo);
            return responseObject;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(), ExceptionType.GENERAL_ERROR.getCode());
        }
    }

    @PostMapping(value = "/reminder/getByDate",produces = "application/json")
    public @ResponseBody
    ResponseObject getReminderByDateRange(@RequestBody String remStr,HttpServletRequest request){
        logger.info("Reminder get by date");
        try {
            if(RequestHelper.isEmptyRequestString(remStr))
                return ResponseObject.getResponse(ExceptionType.INVALID_METHOD_PARAM.getMessage(),ExceptionType.INVALID_METHOD_PARAM.getCode());
            ReminderDateVo reminderDateVo=mapper.readValue(remStr,ReminderDateVo.class);
            ResponseObject responseObject=reminderManager.getReminderByDateRange(reminderDateVo);
            return responseObject;
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
            return ResponseObject.getResponse(ExceptionType.GENERAL_ERROR.getMessage(),ExceptionType.GENERAL_ERROR.getCode());
        }

    }
}
