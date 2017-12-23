package creativei.entity;

import creativei.enums.ComputerKnowledge;
import creativei.enums.EducationQualification;
import creativei.enums.Gender;
import creativei.enums.Occupation;

import javax.persistence.*;
import java.io.Serializable;
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

public class Inquiry extends BaseEntity implements Serializable {

    @Column(nullable = false,name="name")
    private String name;
    @Column(name="inquiry_date",nullable = false)
    private Date inquiryDate;
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

    public Date getInquiryDate() {
        return inquiryDate;
    }

    public void setInquiryDate(Date inquiryDate) {
        this.inquiryDate = inquiryDate;
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
}
