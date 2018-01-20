package creativei.vo;

import creativei.entity.Locality;
import creativei.entity.State;

import java.util.List;

public class AddressDataVo {
    private String country;
    private String state;
    private CityVo city;
    private List<LocalityVo> locality;

    public CityVo getCity() {
        return city;
    }

    public void setCity(CityVo city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<LocalityVo> getLocality() {
        return locality;
    }

    public void setLocality(List<LocalityVo> locality) {
        this.locality = locality;
    }
}
