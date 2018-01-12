package creativei.entity;

import creativei.enums.Source;
import creativei.vo.MarketingVo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "Inquiry_Marketing")
public class InquiryMarketing extends BaseEntity implements Serializable {
    public InquiryMarketing(){}

    public InquiryMarketing(MarketingVo marketingVo){
        this.source=Source.stringToEnum(marketingVo.getSource());
        this.isReferred=marketingVo.getReferred()==null?null:marketingVo.getReferred();
        this.referant=marketingVo.getReferant()==null||marketingVo.getReferant().equals(null)?null:marketingVo.getReferant();
    }

    @OneToOne
    private Inquiry inquiry;
    @Column(nullable = false)
    private Source source;
    @Column(name = "is_referred")
    private boolean isReferred;
    private String referant;

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public boolean getIsReferred() {
        return isReferred;
    }

    public void setIsReferred(boolean isReferred) {
        this.isReferred = isReferred;
    }

    public String getReferant() {
        return referant;
    }

    public void setReferant(String referant) {
        this.referant = referant;
    }
}

