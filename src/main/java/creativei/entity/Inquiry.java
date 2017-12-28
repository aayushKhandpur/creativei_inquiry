package creativei.entity;

import creativei.enums.*;
import creativei.vo.AddressVo;
import creativei.vo.InquiryVo;
import util.LocalizationUtil;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by user on 12/16/2017.
 */
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phone_number"),
        @UniqueConstraint(columnNames = "alternate_phone")
})

public class Inquiry  extends BaseEntity implements Serializable  {

    public Inquiry(InquiryVo inquiryVo) throws Exception {
        this.name=inquiryVo.getName();
        this.areaOfInterest=inquiryVo.getAreaOfInterest();
        this.phoneNumber=inquiryVo.getMobile();
        this.email=inquiryVo.getEmail();
        this.highestEducation=inquiryVo.gethQualification();
        this.dob= LocalizationUtil.stringToDateConverter(inquiryVo.getDob());
        this.gender=inquiryVo.getGender();
    }

    @Column(nullable = false,name="name")
    private String name;
    @Column(name = "inquiry_date", nullable = false)
    private Date inquiryDate=new Date();
    private Gender gender;
    @Column(nullable = false,name="phone_number")
    private String phoneNumber;
    @Column(nullable = false)
    private String email;
    @Column(nullable=false,name = "highest_education")
    private EducationQualification highestEducation;
    private Occupation occupation;
    @Column(name="alternate_phone")
    private String alternatePhone;
    @Column(name="computer_knowledge")
    private ComputerKnowledge computerKnowledge;
    @ManyToOne
    private Branch branch;
    @Column(nullable = false)
    private Date dob;
    @Column(name = "area_of_interest")
    private AreaOfInterest areaOfInterest;
    @OneToOne
    private InquiryAddress inquiryAddress;

    public InquiryAddress getInquiryAddress() {
        return inquiryAddress;
    }

    public void setInquiryAddress(InquiryAddress inquiryAddress) {
        this.inquiryAddress = inquiryAddress;
    }

    public Branch getBranch() { return branch; }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public EducationQualification getHighestEducation() {
        return highestEducation;
    }

    public void setHighestEducation(EducationQualification highestEducation) {
        this.highestEducation = highestEducation;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public String getAlternatePhone() {
        return alternatePhone;
    }

    public void setAlternatePhone(String alternatePhone) {
        this.alternatePhone = alternatePhone;
    }

    public ComputerKnowledge getComputerKnowledge() {
        return computerKnowledge;
    }

    public void setComputerKnowledge(ComputerKnowledge computerKnowledge) {
        this.computerKnowledge = computerKnowledge;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public AreaOfInterest getAreaOfInterest() {
        return areaOfInterest;
    }

    public void setAreaOfInterest(AreaOfInterest areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

}
