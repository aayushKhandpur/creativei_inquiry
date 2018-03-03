package creativei.service;

import creativei.entity.Reminder;
import creativei.exception.InvalidParamRequest;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface ReminderService {
    Reminder create(Reminder reminder) throws InvalidParamRequest;
    List<Reminder> getReminderByDateRange(Date from, Date to) throws InvalidParamRequest;
}
