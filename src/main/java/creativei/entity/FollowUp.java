package creativei.entity;

import creativei.enums.CaseIndex;
import creativei.enums.EducationStatus;
import creativei.enums.FollowUpType;
import creativei.enums.StatusId;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Follow_Up")
public class FollowUp extends BaseEntity implements Serializable {
    @ManyToOne
    private Inquiry inquiry;
    @Column(nullable = false, name = "follow_up_date")
    private Date followUpDate;
    @Column(nullable = false)
    private FollowUpType type;
    @Column(nullable = false, name = "status_id")
    private StatusId statusId;
    private String remark;
    @Column(name = "case_index", nullable = false)
    private CaseIndex caseIndex;

    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Date followUpDate) {
        this.followUpDate = followUpDate;
    }

    public FollowUpType getType() {return type;}

    public void setType(FollowUpType type) {
        this.type = type;
    }

    public StatusId getStatusId() {return statusId;}

    public void setStatusId(StatusId statusId) {this.statusId = statusId;}

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public CaseIndex getCaseIndex() {
        return caseIndex;
    }

    public void setCaseIndex(CaseIndex caseIndex) {
        this.caseIndex = caseIndex;
    }
}
