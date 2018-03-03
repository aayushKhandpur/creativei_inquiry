package creativei.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import creativei.vo.ReminderVo;
import util.LocalizationUtil;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.text.ParseException;
import java.util.Date;

@Entity
public class Reminder extends BaseEntity {
    private String title;
    private String description;
    private Date reminderTime;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Inquiry inquiry;

    public Reminder() {
    }

    public Reminder(ReminderVo reminderVo) throws ParseException {
        this.setId(reminderVo.getId());
        this.title = reminderVo.getTitle();
        this.description = reminderVo.getDescription();
        this.reminderTime = LocalizationUtil.stringtoDateWithTimeConverter(reminderVo.getTime());
        if (reminderVo.getInquiryId()!= null)
            this.inquiry = new Inquiry(reminderVo.getInquiryId());
    }

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
