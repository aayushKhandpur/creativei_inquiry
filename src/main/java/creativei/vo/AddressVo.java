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
