package creativei.vo;

import java.lang.*;
import java.util.List;

public class InquiryVo {
    private String name;
    private String mobile;
    private String email;
    private String dob;
    private String inquiryDate;
    private String hQualification;
    private String areaOfInterest;;
    private String computerKnowledge;
    private AddressVo address;
    private String gender;
    private List<EducationVo> education;
    private GuardianVo guardian;
    private MarketingVo marketing;
    private Long id;

    public MarketingVo getMarketing() {
        return marketing;
    }

    public void setMarketing(MarketingVo marketing) {
        this.marketing = marketing;
    }

    public GuardianVo getGuardian() {
        return guardian;
    }

    public void setGuardian(GuardianVo guardian) {
        this.guardian = guardian;
    }

    public String getComputerKnowledge() {return computerKnowledge;    }

    public void setComputerKnowledge(String computerKnowledge) {this.computerKnowledge = computerKnowledge;}

    public String getInquiryDate() { return inquiryDate;    }

    public void setInquiryDate(String inquiryDate) {
        this.inquiryDate = inquiryDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String gethQualification() { return hQualification;   }

    public void sethQualification(String hQualification) {
        this.hQualification = hQualification;
    }

    public String getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest(String areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    public AddressVo getAddress() {
        return address;
    }

    public void setAddress(AddressVo address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<EducationVo> getEducation() {    return education;    }

    public void setEducation(List<EducationVo> education) {  this.education = education;}
}
