package creativei.entity;


import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Reminder extends BaseEntity {
    private String title;
    private String description;
    private Date reminderTime;
    private Inquiry inquiry;

    public Reminder(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(Date reminderTime) {
        this.reminderTime = reminderTime;
    }

    public Inquiry getInquiry() {
        return inquiry;
    }

    public void setInquiry(Inquiry inquiry) {
        this.inquiry = inquiry;
    }
}
