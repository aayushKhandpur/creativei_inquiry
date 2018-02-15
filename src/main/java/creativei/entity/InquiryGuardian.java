package creativei.entity;

import creativei.enums.Occupation;
import creativei.enums.Relation;
import creativei.vo.GuardianVo;
import util.StringUtil;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name="Inquiry_Guardian")
public class InquiryGuardian extends BaseEntity implements Serializable {
    public InquiryGuardian(){}

    public InquiryGuardian(GuardianVo guardianVo){
        this.setId(guardianVo.getId());
        this.name= StringUtil.validateVo(guardianVo.getName());
        this.relation=Relation.stringToEnum(guardianVo.getRelation());
        this.phoneNumber=StringUtil.validateVo(guardianVo.getPhoneNumber());
        this.email=StringUtil.validateVo(guardianVo.getEmail());
        this.occupation=Occupation.stringToEnum(guardianVo.getOccupation());
    }

    @OneToOne
    private Inquiry inquiry;
    @Column(nullable = false)
    private String name;
    @Column(nullable=false)
    private Relation relation;
    @Column(name="phone_number",nullable = false)
    private String phoneNumber;
    @Column(name="alternate_phone")
    private String alternatePhone;
    private String email;
    private Occupation occupation;

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }
}
