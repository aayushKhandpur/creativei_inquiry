package creativei.entity;

import creativei.helper.constant.DbConstraints;
import creativei.vo.BranchVo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(uniqueConstraints ={
        @UniqueConstraint(columnNames="name", name = DbConstraints.BRANCH_NAME_UNIQUE),
        @UniqueConstraint(columnNames = "mobile", name= DbConstraints.BRANCH_MOBILE_UNIQUE)
        })
public class Branch extends BaseEntity implements Serializable {
    public static final String BRANCH_NAME_UNIQUE = "BRANCH_NAME_UNIQUE";

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;

    @Column(name = "alternate_name" )
    private String alternateName;

    @Column(name = "fixedline_number")
    private String fixedLineNumber;
    @Column(nullable = false)
    private String mobile;
    @Column(nullable = false)
    @org.hibernate.validator.constraints.Email(message = "Invalid Email")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Branch(String name) {
        this.name = name;
    }

    public String getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }

    public String getFixedLineNumber() {
        return fixedLineNumber;
    }

    public void setFixedLineNumber(String fixedLineNumber) {
        this.fixedLineNumber = fixedLineNumber;
    }

    public Branch(){}

    public Branch(BranchVo branchVo){
        this.name = branchVo.getName();
        this.address = branchVo.getAddress();
        this.email = branchVo.getEmail();
        this.fixedLineNumber = branchVo.getFixedLineNumber();
        this.mobile = branchVo.getMobile();
        this.alternateName = branchVo.getAlternateName();
    }
}
