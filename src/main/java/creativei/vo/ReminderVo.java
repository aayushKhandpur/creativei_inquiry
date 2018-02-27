package creativei.vo;

import creativei.entity.Reminder;
import util.LocalizationUtil;

public class ReminderVo {

    private Long id;
    private String title;
    private String description;
    private String time;
    private Long inquiryId;

    public ReminderVo(){}

    public  ReminderVo(Reminder reminder){
        this.id=reminder.getId();
        this.title=reminder.getTitle();
        this.description=reminder.getDescription();
        this.time= LocalizationUtil.getFormattedDateWithTime(reminder.getReminderTime());
        if(reminder.getInquiry()!=null)
            this.inquiryId=reminder.getInquiry().getId();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Long getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(Long inquiryId) {
        this.inquiryId = inquiryId;
    }
}
