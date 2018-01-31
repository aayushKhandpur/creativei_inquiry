package creativei.entity;

import creativei.vo.AddressVo;
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
        this.area=addressVo.getArea()==null||addressVo.getArea().isEmpty()?null:addressVo.getArea();
        this.city=addressVo.getCity()==null||addressVo.getCity().isEmpty()?null:addressVo.getCity();
        this.pincode=addressVo.getPin()==null||addressVo.getPin().isEmpty()?null:addressVo.getPin();
        this.addressLine1=addressVo.getAddressLine1()==null||addressVo.getAddressLine1().isEmpty()?null:addressVo.getAddressLine1();
        this.country=addressVo.getCountry()==null||addressVo.getCountry().isEmpty()?null:addressVo.getCountry();
        this.state=addressVo.getState()==null||addressVo.getState().isEmpty()?null:addressVo.getState();
        this.location=new Locality(addressVo.getLocationId());
    }
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Inquiry.id")
    private Inquiry inquiry;
    @Column(nullable = false)
    private String pincode;
    @Column(nullable = false)
    private String country="INDIA";
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String city="JAIPUR";
    @Column(nullable = false)
    private String area;
    @Column(name = "address_line_1")
    private String addressLine1;
    @Column(name="address_line_2")
    private String addressLine2;
    @Column(name = "is_current")
    private boolean isCurrent = true;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
    private Locality location;

    public Locality getLocation() {
        return location;
    }

    public void setLocation(Locality location) {
        this.location = location;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {this.city = city; }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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
}
