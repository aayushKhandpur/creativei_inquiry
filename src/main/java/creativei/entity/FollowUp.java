package creativei.entity;

import creativei.enums.CaseIndex;
import creativei.enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by user on 12/22/2017.
 */
@Entity
@Table(name="Follow_Up")
public class FollowUp extends BaseEntity implements Serializable {
    @ManyToOne
    private Inquiry inquiry;
    @Column(nullable = false,name="follow_up_date")
    private Date followUpDate;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false,name = "status_id")
    private Status statusId;
    private String remark;
    private String state;
    @Column(name = "case_index",nullable = false)
    private CaseIndex caseIndex;

    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Date followUpDate) {
        this.followUpDate = followUpDate;
    }

    public String getType() {return type;}

    public void setType(String type) {
        this.type = type;
    }

    public Status getStatusId() {
        return statusId;
    }

    public void setStatusId(Status statusId) {
        this.statusId = statusId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public CaseIndex getCaseIndex() {
        return caseIndex;
    }

    public void setCaseIndex(CaseIndex caseIndex) {
        this.caseIndex = caseIndex;
    }
}
