package creativei.service.impl;

import creativei.dao.ReminderCustomDao;
import creativei.entity.Reminder;
import creativei.exception.InvalidParamRequest;
import creativei.service.ReminderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.LocalizationUtil;
import util.StringUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service("ReminderService")
public class ReminderServiceImpl implements ReminderService {
    @Autowired
    ReminderCustomDao reminderCustomDao;

    Logger logger = LoggerFactory.getLogger(ReminderServiceImpl.class);

    @Override
    public Reminder create(Reminder reminder) throws InvalidParamRequest {
        logger.info(" Service reminder create");
        if (!validateReminder(reminder)) {
            throw new InvalidParamRequest("Required Field are null");
        }
        return reminderCustomDao.save(reminder);
    }

    @Override
    public List<Reminder> getReminderByDateRange(String param1, String param2) throws ParseException {
        logger.info("getReminderDateRange Method");
        if (param1.equalsIgnoreCase("null")) {
            param1 = param2;
            param2 = LocalizationUtil.getFormattedDateWithTime(new Date());
        }
        Date to = LocalizationUtil.stringtoDateWithTimeConverter(param1);
        Date from = LocalizationUtil.stringtoDateWithTimeConverter(param2);
        return reminderCustomDao.findRemindersBetweenDates(to, from);
    }

    private Boolean validateReminder(Reminder reminder) {
        logger.info("Validate Reminder");
        if (StringUtil.validateEmpty(reminder.getTitle()) == null) {
            logger.error("Reminder title is invalid " + reminder.getTitle());
            return false;
        }
        if (reminder.getReminderTime() == null) {
            logger.error("Reminder time is invalid " + reminder.getReminderTime());
            return false;
        }
        return true;
    }
}
