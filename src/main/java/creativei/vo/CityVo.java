package creativei.vo;

import java.util.List;

public class CityVo {
    private Long id;
    private String city;
    private String country;
    private String state;
    private List<LocalityVo> locality;

    public CityVo(){}

    public CityVo(Long id ,String city,String country,String state,List<LocalityVo> locality){
        this.id=id;
        this.city=city;
        this.country=country;
        this.state=state;
        this.locality=locality;
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
