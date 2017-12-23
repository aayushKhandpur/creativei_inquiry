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
        @UniqueConstraint(columnNames = "ph_num"),
        @UniqueConstraint(columnNames = "alt_num")
})

public class Inquiry extends BaseEntity implements Serializable {




    @Column(nullable = false,name="name")
    private String name;
    @Column(name="inq_date",nullable = false)
    private Date inqDate;
    private Gender gender;
    @Column(nullable = false,name="ph_num")
    private String phNum;
    @Column(nullable = false)
    private String email;
    @Column(nullable=false,name = "h_qual")
    private EducationQualification hEdu;
    private Occupation occ;
    @Column(name="alt_num")
    private String altNum;
    @Column(name="comp_knw")
    private ComputerKnowledge compKnw;
    @ManyToOne
     private Branch branch;
       public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getInqDate() {
        return inqDate;
    }

    public void setInqDate(Date inqDate) {
        this.inqDate = inqDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhNum() {
        return phNum;
    }

    public void setPhNum(String phNum) {
        this.phNum = phNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EducationQualification gethEdu() {
        return hEdu;
    }

    public void sethEdu(EducationQualification hEdu) {
        this.hEdu = hEdu;
    }

    public Occupation getOcc() {
        return occ;
    }

    public void setOcc(Occupation occ) {
        this.occ = occ;
    }

    public String getAltNum() {
        return altNum;
    }

    public void setAltNum(String altNum) {
        this.altNum = altNum;
    }

    public ComputerKnowledge getCompKnw() {
        return compKnw;
    }

    public void setCompKnw(ComputerKnowledge compKnw) {
        this.compKnw = compKnw;
    }


}
