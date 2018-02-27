package creativei.service.impl;

import creativei.dao.ReminderCustomDao;
import creativei.dao.ReminderDao;
import creativei.entity.Reminder;
import creativei.exception.InvalidParamRequest;
import creativei.service.ReminderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.StringUtil;

@Service("ReminderService")
public class ReminderServiceImpl implements ReminderService{
    @Autowired
    ReminderCustomDao reminderCustomDao;

    Logger logger= LoggerFactory.getLogger(ReminderServiceImpl.class);

    @Override
    public Reminder create(Reminder reminder) throws InvalidParamRequest {
        logger.info(" Service reminder create");
        if(!validateReminder(reminder)){
            throw new InvalidParamRequest("Required Field are null");
        }
        return reminderCustomDao.save(reminder);
    }

    private Boolean validateReminder(Reminder reminder){
        logger.info("Validate Reminder");
        if(StringUtil.validateEmpty(reminder.getTitle())==null){
            logger.error("Reminder title is invalid "+reminder.getTitle());
            return false;
        }
        if(reminder.getReminderTime()==null){
            logger.error("Reminder time is invalid "+reminder.getReminderTime());
            return false;
        }
        return true;
    }
}