package creativei.vo;

import creativei.entity.State;

import java.util.List;

public class AddressDataVo {
    private String country;
    private StateVo state;
    private String city;
    private List<String> locality;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public StateVo getState() {
        return state;
    }

    public void setState(StateVo state) {
        this.state = state;
    }

    public List<String> getLocality() {
        return locality;
    }

    public void setLocality(List<String> locality) {
        this.locality = locality;
    }
}
