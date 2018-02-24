package creativei.service;

import creativei.entity.Reminder;
import creativei.exception.InvalidParamRequest;

public interface ReminderService {
    Reminder create(Reminder reminder) throws InvalidParamRequest;
}
