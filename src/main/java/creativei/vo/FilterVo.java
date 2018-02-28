package creativei.vo;

/**
 * Created by user on 2/16/2018.
 */
public class FilterVo {
    InquiryVo inquiryVo;
    FollowUpVo followUpVo;
    CityVo cityVo;
    public FollowUpVo getFollowUpVo() {
        return followUpVo;
    }

    public void setFollowUpVo(FollowUpVo followUpVo) {
        this.followUpVo = followUpVo;
    }

    public CityVo getCityVo() {
        return cityVo;
    }

    public void setCityVo(CityVo cityVo) {
        this.cityVo = cityVo;
    }

    public InquiryVo getInquiryVo() {

        return inquiryVo;
    }

    public void setInquiryVo(InquiryVo inquiryVo) {
        this.inquiryVo = inquiryVo;
    }
}
