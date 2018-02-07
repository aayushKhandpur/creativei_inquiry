package creativei.entity;

import creativei.vo.AddressVo;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.engine.internal.Cascade;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Inquiry_Address")
public class InquiryAddress extends BaseEntity implements Serializable {

    public InquiryAddress(){}

    public InquiryAddress(AddressVo addressVo){
        this.setId(addressVo.getId());
        this.pincode=addressVo.getPin()==null||addressVo.getPin().isEmpty()?null:addressVo.getPin();
        this.addressLine1=addressVo.getAddressLine1()==null||addressVo.getAddressLine1().isEmpty()?null:addressVo.getAddressLine1();
        this.location=new Locality(addressVo.getLocationId());
    }
    @OneToOne
    private Inquiry inquiry;
    @Column(nullable = false)
    private String pincode;
    @Column(name = "address_line_1")
    private String addressLine1;
    @Column(name="address_line_2")
    private String addressLine2;
    @Column(name = "is_current")
    private boolean isCurrent = true;
    @ManyToOne(cascade = {CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
    private Locality location;

    public Locality getLocation() {
        return location;
    }

    public void setLocation(Locality location) {
        this.location = location;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public boolean is_current() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        this.isCurrent = current;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
