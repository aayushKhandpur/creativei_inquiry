package creativei.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import creativei.entity.Inquiry;
import creativei.entity.InquiryAddress;
import creativei.entity.Locality;

public class AddressVo {

    private String pin;
    private String addressLine1;
    private Long id;
    private Long locationId;
    private String city;
    private String area;
    private String country;
    private String state;

    public AddressVo(){}

    public AddressVo(String area, String city, String state, String country) {
        this.area=area;
        this.city=city;
        this.state=state;
        this.country=country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
