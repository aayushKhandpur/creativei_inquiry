package creativei.vo;

import creativei.entity.InquiryGuardian;
import creativei.enums.Occupation;
import creativei.enums.Relation;

public class GuardianVo {
    private Long id;
    private String name;
    private String phoneNumber;
    private String email;
    private String occupation;
    private String relation;

    public GuardianVo(){}

    public GuardianVo(InquiryGuardian inquiryGuardian){
        this.setId(inquiryGuardian.getId());
        this.name=inquiryGuardian.getName();
        this.email=inquiryGuardian.getEmail();
        this.phoneNumber=inquiryGuardian.getPhoneNumber();
        this.occupation= Occupation.enumToString(inquiryGuardian.getOccupation());
        this.relation= Relation.enumToString(inquiryGuardian.getRelation());
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public Long getId() {  return id;}

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
