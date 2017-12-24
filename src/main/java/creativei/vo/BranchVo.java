package creativei.vo;

import creativei.entity.Branch;

/**
 * Created by Aayush on 12/24/2017.
 */
public class BranchVo {
    private String name;
    private String address;
    private String fixedLineNumber;
    private String mobile;
    private String email;
    private String alternateName;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getFixedLineNumber() {
        return fixedLineNumber;
    }

    public void setFixedLineNumber(String fixedLineNumber) {
        this.fixedLineNumber = fixedLineNumber;
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

    public String getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(String alternateName) {
        this.alternateName = alternateName;
    }
}
